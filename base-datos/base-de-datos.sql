/*
 Navicat Premium Data Transfer

 Source Server         : Fastore
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3308
 Source Schema         : fastore

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 17/05/2020 20:55:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categorias
-- ----------------------------
DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias`  (
  `id_categoria` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_categoria`) USING BTREE,
  UNIQUE INDEX `categoria_id_categoria`(`id_categoria`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of categorias
-- ----------------------------
BEGIN;
INSERT INTO `categorias` VALUES (3, 'Modelo Especial'), (4, 'Victoria'), (5, 'Barrilito'), (6, 'Corona Light');
COMMIT;


-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ubicacion` varchar(90) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `telefono` varchar(90) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `correo` varchar(90) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` blob NULL,
  `tipo_usuario` char(9) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `correo`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
BEGIN;
INSERT INTO `usuarios` VALUES (1, 'abarrotes lupita', 'lazaro cardenas #4322', '3340406562', 'lupita@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (2, 'La tiendita', 'Rio Nilo #123', '3331891822', 'latiendita@gmail.com', 0x32396539316532616365386135346166373163333862393465336135356236663461343361343532, 'CLIENTE'), (3, 'abarrotes shely', 'clavel #644', '3322340418', 'Shely@gmail.com', 0x64373438396666313539326462353831643031663664663836636162363739626662633333386337, 'CLIENTE'), (4, 'tienda mis 3 bendeiciones', 'Calle Toronja #668', '3325822242', 'tienda@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (5, 'Abarrotes Don Jorge', 'Calle Girasol #345', '3332456728', 'jorge@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (6, 'abarroteria la esquina', 'Av. los Olimpos #456', '3690405568', 'laesquina@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (7, 'Coca Cola', 'AV. Vallarta #538', '3899178136', 'cocacola@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'PROVEEDOR'), (8, 'Coca-Cola', 'Periférico sur', '36505050', 'coca@gmail.com', 0x37633461386430396361333736326166363165353935323039343364633236343934663839343162, 'CLIENTE'), (8, 'Sabritas', 'Lázaro Cárdenas #122', '3327284941', 'sabri@direccion.net', 0x37633461386430396361333736326166363165353935323039343364633236343934663839343162, 'PROVEEDOR'), (8, 'Malta', 'Bugambilias #44', '3327284941', 'sandylashina@gmail.com', 0x64626239326339626138363938366362643563613031326333313236646465616136613565383239, 'CLIENTE'), (9, 'coca', 'peri #123', '36505050', 'coca@gmail.com', 0x37633461386430396361333736326166363165353935323039343364633236343934663839343162, 'CLIENTE'), (9, 'Corona', 'López Mateos 23', '3327284941', 'corona@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'PROVEEDOR'), (10, 'Cervecería Corona', 'Jalisco Guadalajara Av.Zapotlanejo #244', '36554585', 'corona@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'PROVEEDOR'), (10, 'pepsi', 'zalate 1233', '33837489', 'ppsi@gmail.com', 0x37633461386430396361333736326166363165353935323039343364633236343934663839343162, 'CLIENTE'), (11, 'marinela', 'Río Nilo #12', '3312326292', 'mari@nela.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'PROVEEDOR'), (11, 'sabritas', 'la torre 123', '34563456', 'sabri@gmail.com', 0x37633461386430396361333736326166363165353935323039343364633236343934663839343162, 'CLIENTE'), (12, 'sabri', 'jiji', '2134', 'sabri@gmail.com', 0x34306264303031353633303835666333353136353332396561316666356335656362646262656566, 'CLIENTE'), (13, 'qwertyui', 'asdcfvbnm', '123', 'a@gmail.com', 0x34306264303031353633303835666333353136353332396561316666356335656362646262656566, 'CLIENTE'), (14, 'Tienda Doña JO', 'Jauja,  Martín 455', '3321223262', 'jo@gmail.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (15, 'Abarrotes Malta', 'Bugambilias 44', '3313331333', 'mal@ta.com', 0x37633232326662323932376438323861663232663539323133346538393332343830363337633064, 'CLIENTE'), (16, 'Sabripobres', 'Juan de La barrera 1322', '3315464703', 'jlriverag@gmail.com', 0x61666665376362636364383266303765353663303538396564306464663332666539396132343434, 'PROVEEDOR'), (18, 'ppLuiGui', 'Ubicacion', 'Telefono', 'pp_luigui@yahoo.com', 0x62313766343738376632373939663236363565356631313966633266343764353639323132633463, 'CLIENTE'), (19, 'MrWizard', 'Ubicacion', 'Telefono', 'pp_luigui@hotmail.com', 0x62313766343738376632373939663236363565356631313966633266343764353639323132633463, 'PROVEEDOR');
COMMIT;

-- ----------------------------
-- Table structure for comentarios
-- ----------------------------
DROP TABLE IF EXISTS `comentarios`;
CREATE TABLE `comentarios`  (
  `id_comentario` int(10) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `fecha` date NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `proveedor_id` int(11) NULL DEFAULT NULL,
  `leido` int(11) NOT NULL,
  PRIMARY KEY (`id_comentario`, `cliente_id`, `leido`) USING BTREE,
  UNIQUE INDEX `comentarios_id_comentario`(`id_comentario`) USING BTREE,
  INDEX `comentarios_id_cliente`(`cliente_id`) USING BTREE,
  INDEX `comentarios_id_proveedor`(`proveedor_id`) USING BTREE,
  CONSTRAINT `com_clie_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `com_prv_id` FOREIGN KEY (`proveedor_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of comentarios
-- ----------------------------
BEGIN;
INSERT INTO `comentarios` VALUES (1, 'Click here to download the JDatePicker library from SourceForge. The latest version as of now is 1.3.2. Extract the downloaded archive JDatePicker-1.3.2-dist.zip, and then find and add the jdatepicker-1.3.2.jar file to your project’s classpath.', '2020-05-17', 6, 16, 1);
COMMIT;

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos`  (
  `id_producto` int(10) NOT NULL AUTO_INCREMENT,
  `clave` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `precio` float NOT NULL,
  `unidad` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `detalles` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `proveedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`) USING BTREE,
  UNIQUE INDEX `productos_id_producto`(`id_producto`) USING BTREE,
  INDEX `productos_categoria_id`(`categoria_id`) USING BTREE,
  INDEX `productos_proveedor_id`(`proveedor_id`) USING BTREE,
  CONSTRAINT `productos_categorias_categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_categoria`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `productos_proveedores_proveedor_id` FOREIGN KEY (`proveedor_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of productos
-- ----------------------------
BEGIN;
INSERT INTO `productos` VALUES (2, 'VIC-00001', 'VICTORIA', 324, '24 latas por caja', '355ml cada una', 3, 10), (3, 'MOD-00001', 'MODELO ESPECIAL', 425.35, '24 LATAS POR CAJA', 'LATÓN DE 355ML CADA UNA', 3, 10), (4, '1', 'Coca de Medio', 10, 'Botella', 'Botella de 500ml', 3, 10);
COMMIT;


-- ----------------------------
-- Table structure for pedidos
-- ----------------------------
DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos`  (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `proveedor_id` int(11) NULL DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL,
  `status` int(10) NOT NULL,
  PRIMARY KEY (`id_pedido`) USING BTREE,
  UNIQUE INDEX `pedidos_id_pedido`(`id_pedido`) USING BTREE,
  INDEX `pedidos_cliente_id`(`cliente_id`) USING BTREE,
  INDEX `pedidos_proveedor_id`(`proveedor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of pedidos
-- ----------------------------
BEGIN;
INSERT INTO `pedidos` VALUES (5, 10, 16, '2020-05-17', 12.23, 1), (6, 16, 16, '2020-05-17', 30, 1), (7, 16, 16, '2020-05-17', 10, 1), (8, 11, 16, '2020-05-17', 860.7, 1);
COMMIT;

-- ----------------------------
-- Table structure for pedidos_detalles
-- ----------------------------
DROP TABLE IF EXISTS `pedidos_detalles`;
CREATE TABLE `pedidos_detalles`  (
  `id_pedido_detalles` int(10) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(10) NOT NULL,
  `id_producto` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `precio` float NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido_detalles`) USING BTREE,
  UNIQUE INDEX `peddtl_id_pdtl`(`id_pedido_detalles`) USING BTREE,
  INDEX `id_producto`(`id_producto`) USING BTREE,
  INDEX `pedido_id_producto`(`id_pedido`) USING BTREE,
  CONSTRAINT `pedidos_detalles_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci;

-- ----------------------------
-- Records of pedidos_detalles
-- ----------------------------
BEGIN;
INSERT INTO `pedidos_detalles` VALUES (3, 5, 4, 3, 10), (4, 5, 4, 21, 10), (5, 5, 3, 21, 425.35), (7, 6, 4, 1, 10), (8, 6, 4, 2, 10), (9, 7, 4, 1, 10), (10, 8, 4, 1, 10), (11, 8, 3, 2, 425.35);
COMMIT;




SET FOREIGN_KEY_CHECKS = 1;
