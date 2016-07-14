
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
INSERT INTO `user_admin` (`seq`, `id`, `passwd`, `role_id`, `name`, `phone`, `receipt_email_yn`, `error_email_yn`, `login_cnt`, `last_login_date`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 'seller', '11111', 'ROLE_SELLER', '셀러', '010-1111-1111', '0', '0', 0, NOW(), '0', '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `store_seller`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `store_seller` (`seq`, `admin_seq`, `parent_seq`, `name`, `phone`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 1, NULL, '스토어_셀러', '02-111-1111', '0', '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_manager`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_manager` (`seq`, `id`, `passwd`, `name`, `phone`, `subscription_channel`, `use_yn`, `del_yn`, `regdate`) VALUES (1, 'manager1', '1111', '사장님1', '010-2222-2222', '0', '0', '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `store_owner`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `store_owner` (`seq`, `seller_seq`, `manager_seq`, `name`, `sf_ver`, `status`, `bizapp_use_yn`, `del_yn`, `regdate`) VALUES (1, 1, 1, '가맹점주1', 'v0.1', '2', '0', '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_employee`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_employee` (`seq`, `owner_seq`, `manager_seq`, `name`, `type`, `code`, `work_start_date`, `work_end_date`, `birthday`, `phone`, `memo`, `del_yn`, `regdate`) VALUES (1, 1, 1, '담당자1', '0', '1111', '160501', '161031', '850130', '010-2222-2222', NULL, '0', NOW());
INSERT INTO `user_employee` (`seq`, `owner_seq`, `manager_seq`, `name`, `type`, `code`, `work_start_date`, `work_end_date`, `birthday`, `phone`, `memo`, `del_yn`, `regdate`) VALUES (2, 1, 1, '담당자2', '1', '1111', '160501', '161130', '880921', '010-3333-3333', NULL, '0', NOW());

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_pos`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user_pos` (`seq`, `manager_seq`, `owner_seq`, `type`, `mac_address`, `del_yn`, `regdate`) VALUES (1, 1, 1, '0', '08-62-66-2D-F3-0C', '0', NOW());
INSERT INTO `user_pos` (`seq`, `manager_seq`, `owner_seq`, `type`, `mac_address`, `del_yn`, `regdate`) VALUES (2, 1, 1, '1', '08-62-66-2D-F3-0D', '0', NOW());

COMMIT;
