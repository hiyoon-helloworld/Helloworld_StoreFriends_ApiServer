-- -----------------------------------------------------
-- Data for table `user_admin_role`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_admin_role` (`id`, `name`) VALUES ('ROLE_SELLER', 'SELLER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_admin`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_admin` (`seq`, `id`, `passwd`, `role_id`, `name`, `phone`, `receipt_email_yn`, `error_email_yn`, `login_cnt`, `last_login_date`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 'seller', '11111', 'ROLE_SELLER', '셀러', '010-1111-1111', '0', '0', 0, NOW(), 'N', 'N', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `store_seller`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `store_seller` (`seq`, `admin_seq`, `parent_seq`, `name`, `phone`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 1, NULL, '스토어_셀러', '02-111-1111', 'N', 'N', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_manager`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_manager` (`seq`, `id`, `passwd`, `name`, `phone`, `subscription_channel`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 'manager1', '1111', '사장님1', '010-2222-2222', '0', '0', '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `store_root`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `store_root` (`seq`, `seller_seq`, `manager_seq`, `name`, `sf_ver`, `status`, `bizapp_use_yn`, `del_yn`, `regdate`) VALUES (1, 1, 1, '가맹점주1', 'v0.1', '2', 'N', 'N', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `store`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `store` (`seq`, `root_seq`, `seller_seq`, `name`, `phone`, `cell_phone`, `virtual_phone`, `store_type`, `tts_use_yn`, `tts_notify_use_yn`, `tts_phone`, `tts_phone_etc`, `category`, `push_server_url`, `delv_min_price`, `delv_able_region_avbbv`, `logo_img_url`, `paper_img_url`, `use_store_yn`, `use_delivery_yn`, `use_package_yn`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 1, 1, '스토어1', '0211101234', '01023451234', '0212345678', '0', 'N', 'N', '0213450123', NULL, '0', NULL, 100, '율량동,상일동', NULL, NULL, 'Y', 'Y', 'Y', 'Y', 'Y', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_employee`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_employee` (`seq`, `root_seq`, `manager_seq`, `name`, `type`, `code`, `work_start_date`, `work_end_date`, `birthday`, `phone`, `memo`, `del_yn`, `regdate`) VALUES (1, 1, 1, '담당자1', '0', '1111', '160501', '161031', '850130', '010-2222-2222', NULL, 'N', NOW());
INSERT INTO `user_employee` (`seq`, `root_seq`, `manager_seq`, `name`, `type`, `code`, `work_start_date`, `work_end_date`, `birthday`, `phone`, `memo`, `del_yn`, `regdate`) VALUES (2, 1, 1, '담당자2', '1', '1111', '160501', '161130', '880921', '010-3333-3333', NULL, 'N', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_pos`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_pos` (`seq`, `manager_seq`, `root_seq`, `type`, `mac_address`, `del_yn`, `regdate`) VALUES (1, 1, 1, '0', '08-62-66-2D-F3-0C', 'N', NOW());
INSERT INTO `user_pos` (`seq`, `manager_seq`, `root_seq`, `type`, `mac_address`, `del_yn`, `regdate`) VALUES (2, 1, 1, '1', '08-62-66-2D-F3-0D', 'N', NOW());

COMMIT;

