package com.hellowd.core.model.type;

import com.hellowd.core.model.http.common.ApiResult;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-15
 * Time : 오전 11:04
 * 해당 클래스에 대한 기능 설명
 */
public class HttpStatusType {

    /**
     * 운영 STATUS TYPE.
     */
    public enum OPERATION_STATUS_TYPE {

        OK(200), IS_BUSINESS_NOW(10000), CAN_OPEN_TWICE_PER_DAY(10001); // ENUM
        private int status; // 상태값
        OPERATION_STATUS_TYPE(int status) {this.status = status;} // 생성자

        public int getStatus() {
            return this.status;
        }

        /**
         * 해당 코드에 맞는 메시지를 반환합니다.
         * @return
         */
        public String getMessage() {
            String message = "";
            switch (status) {
                case 200:
                    message = "영업시작 정상처리";
                    break;
                case 10000:
                    message = "현재 영업중이므로 영업시작 할 수 없습니다.";
                    break;
                case 10001:
                    message = "하루에 2번까지만 영업시작 가능합니다.";
                    break;
                default:
                    message = "";
                    break;
            }
            return message;
        }

        public ApiResult getApiResult() {
            return new ApiResult(this == OK ? true : false, getStatus(), getMessage());
        }
    }
}
