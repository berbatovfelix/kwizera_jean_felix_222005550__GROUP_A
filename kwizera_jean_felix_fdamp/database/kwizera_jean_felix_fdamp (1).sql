-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:43 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kwizera_jean_felix_fdamp`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalculateAverageFuelQuantity` (IN `p_fuel_type` VARCHAR(50), OUT `p_average_quantity` DECIMAL(10,2))   BEGIN
    SELECT AVG(subquery.quantity) INTO p_average_quantity
    FROM (
        SELECT t.quantity
        FROM ORDERS o
        JOIN transaction t ON o.order_id = t.order_id
        WHERE o.fuel_type = p_fuel_type
    ) AS subquery;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteInactiveCustomerAndORDERS` ()   BEGIN
    DELETE FROM customer
    WHERE DATEDIFF(NOW(),quentity) > 30000;
     DELETE FROM orders
    WHERE customer_id NOT IN (SELECT customer_id FROM ORDERS WHERE DATEDIFF(NOW(), order_quentity) <= 30000);
    
    SELECT 'Inactive users and customers deleted successfully.' AS message;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteInactiveUsersAndCustomers` ()   BEGIN
    DELETE FROM user
    WHERE DATEDIFF(NOW(), last_login_date) > 365;
     DELETE FROM customer
    WHERE customer_id NOT IN (SELECT customer_id FROM ORDERS WHERE DATEDIFF(NOW(), order_date) <= 365);
    
    SELECT 'Inactive users and customers deleted successfully.' AS message;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAllData` ()   BEGIN
    SELECT * FROM user;
SELECT * FROM bank;
    SELECT * FROM customer;
    SELECT * FROM driver;
    SELECT * FROM fuel_admin;
    SELECT * FROM fuel_deliveryorders;
    SELECT * FROM fuel_deliveryrecord;
    SELECT * FROM fuel_station;
   SELECT * FROM fuel_suppler;
    SELECT * FROM fuel_type;
   SELECT * FROM order_assignment;
    SELECT * FROM order_history;
   SELECT * FROM ORDERS;
   SELECT * FROM transaction;
   SELECT * FROM vehicle;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertBank` (IN `p_name` VARCHAR(10), IN `p_address` VARCHAR(40), IN `p_account_number` INT, IN `p_phone_number` VARCHAR(10), IN `p_routing_number` INT)   BEGIN
    INSERT INTO bank (name, address, account_number, phone_number, routing_number)
    VALUES (p_name, p_address, p_account_number, p_phone_number, p_routing_number);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertCustomer` (IN `p_first_name` VARCHAR(25), IN `p_last_name` VARCHAR(50), IN `p_email` VARCHAR(100), IN `p_phone` VARCHAR(10), IN `p_address` VARCHAR(50), IN `p_payment_method` VARCHAR(10))   BEGIN
    INSERT INTO customer (first_name, last_name, emai, phone, address, payment_method)
    VALUES (p_first_name, p_last_name, p_email, p_phone, p_address, p_payment_method);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertDriver` (IN `p_first_name` VARCHAR(50), IN `p_last_name` VARCHAR(40), IN `p_phone` VARCHAR(10), IN `p_licence_number` VARCHAR(20), IN `p_vehicle_id` INT)   BEGIN
    INSERT INTO driver (first_name, last_name, phone, licence_number, vehicle_id)
    VALUES (p_first_name, p_last_name, p_phone, p_licence_number, p_vehicle_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelAdmin` (IN `p_email` VARCHAR(50), IN `p_password` VARCHAR(50), IN `p_first_name` VARCHAR(50), IN `p_last_name` VARCHAR(50), IN `p_phone_number` VARCHAR(100), IN `p_permissions` VARCHAR(8))   BEGIN
    INSERT INTO fuel_admin (Email, Password, first_name, last_name, phone_number, permissions)
    VALUES (p_email, p_password, p_first_name, p_last_name, p_phone_number, p_permissions);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelDeliveryOrder` (IN `p_fuelsup_id` INT, IN `p_order_id` INT, IN `p_date_delivered` DATE)   BEGIN
    INSERT INTO fuel_deliveryorders (fuelsup_id, order_id, date_delivered)
    VALUES (p_fuelsup_id, p_order_id, p_date_delivered);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelDeliveryRecord` (IN `p_order_id` INT, IN `p_driver_id` INT, IN `p_fuelsta_id` INT, IN `p_quantity` INT, IN `p_date_delivered` DATE)   BEGIN
    INSERT INTO fuel_deliveryrecord (order_id, driver, fuelsta_id, quantity, date_delivered)
    VALUES (p_order_id, p_driver_id, p_fuelsta_id, p_quantity, p_date_delivered);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelStation` (IN `p_name` VARCHAR(50), IN `p_address` VARCHAR(30), IN `p_phone` VARCHAR(10), IN `p_fuel_type` VARCHAR(20))   BEGIN
    INSERT INTO fuel_station (name, address, phone, fuel_type)
    VALUES (p_name, p_address, p_phone, p_fuel_type);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelSuppler` (IN `p_first_name` VARCHAR(50), IN `p_last_name` VARCHAR(50), IN `p_email` VARCHAR(40), IN `p_address` VARCHAR(40), IN `p_phone_number` VARCHAR(10))   BEGIN
    INSERT INTO fuel_suppler (first_name, last_name, email, address, phone_number)
    VALUES (p_first_name, p_last_name, p_email, p_address, p_phone_number);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFuelType` (IN `p_name` VARCHAR(30), IN `p_price` INT)   BEGIN
    INSERT INTO fuel_type (name, price)
    VALUES (p_name, p_price);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertOrder` (IN `p_customer_id` INT, IN `p_driver_id` INT, IN `p_fuelsta_id` INT, IN `p_fuel_type` VARCHAR(50), IN `p_quentity` INT, IN `p_total_price` INT)   BEGIN
    INSERT INTO ORDERS (customer_id, driver_id, fuelsta_id, fuel_type, quentity, total_price)
    VALUES (p_customer_id, p_driver_id, p_fuelsta_id, p_fuel_type, p_quantity, p_total_price);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertOrderAssignment` (IN `p_order_id` INT, IN `p_driver_id` INT)   BEGIN
    INSERT INTO order_assignment (order_id, driver_id)
    VALUES (p_order_id, p_driver_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertOrderHistory` (IN `p_customer_id` INT, IN `p_order_id` INT)   BEGIN
    INSERT INTO order_history (customer_id, order_id)
    VALUES (p_customer_id, p_order_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertUser` (IN `p_first_name` VARCHAR(25), IN `p_last_name` VARCHAR(20), IN `p_phone_number` INT, IN `p_email` VARCHAR(67), IN `p_role` VARCHAR(80))   BEGIN
    INSERT INTO user (first_name, last_name, phone_number, email, role)
    VALUES (p_first_name, p_last_name, p_phone_number, p_email, p_role);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertVehicle` (IN `p_vehicle_name` VARCHAR(20), IN `p_prake_name` VARCHAR(15))   BEGIN
    INSERT INTO vehicle (vehicle_name, prake_name)
    VALUES (p_vehicle_name, p_prake_name);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateCustomerInfo` (IN `p_customer_id` INT, IN `p_new_first_name` VARCHAR(25), IN `p_new_last_name` VARCHAR(50), IN `p_new_email` VARCHAR(100), IN `p_new_phone` VARCHAR(10), IN `p_new_address` VARCHAR(50), IN `p_new_payment_method` VARCHAR(10))   BEGIN
     IF (SELECT COUNT(*) FROM customer WHERE customer_id = p_customer_id) > 0 THEN
        UPDATE customer
        SET
            first_name = p_new_first_name,
            last_name = p_new_last_name,
            emai = p_new_email,
            phone = p_new_phone,
            address = p_new_address,
            payment_method = p_new_payment_method
        WHERE customer_id = p_customer_id;
        
        SELECT 'Customer information updated successfully.' AS message;
    ELSE
        SELECT 'Customer not found. No updates performed.' AS message;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateUserInfo` (IN `p_user_id` INT, IN `p_new_first_name` VARCHAR(25), IN `p_new_last_name` VARCHAR(20), IN `p_new_phone_number` INT, IN `p_new_email` VARCHAR(67), IN `p_new_role` VARCHAR(80))   BEGIN
    IF (SELECT COUNT(*) FROM user WHERE user_id = p_user_id) > 0 THEN
        
        UPDATE user
        SET
            first_name = p_new_first_name,
            last_name = p_new_last_name,
            phone_number = p_new_phone_number,
            email = p_new_email,
            role = p_new_role
        WHERE user_id = p_user_id;
        
        SELECT 'User information updated successfully.' AS message;
    ELSE
        SELECT 'User not found. No updates performed.' AS message;
    END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `banks`
--

CREATE TABLE `banks` (
  `banks_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `address` varchar(40) NOT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `account_number` varchar(10) NOT NULL,
  `bankname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `banks`
--

INSERT INTO `banks` (`banks_id`, `name`, `address`, `phone_number`, `account_number`, `bankname`) VALUES
(3, 'mukesha', '@dfg', '07888885', '454545', 'EQUITY BANK'),
(4, 'xx', 'ss', 'sssxs', 'sss', 'EQUITY BANK'),
(5, 'inka', 'dfgh', '345767', '23456', 'SACCO'),
(7, 'rulinda jackson', 'huye', '0788888', '101010', 'ZIGAMA'),
(8, 'dfg', 'tyh', '1234567', '1324567', 'BNR'),
(9, 'tov', 'wow', 'wow', '456', 'BNR'),
(10, 'liza', 'rwanda', '0788888', '898989', 'BNR');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `emai` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `payment_method` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `last_name`, `first_name`, `emai`, `phone`, `address`, `payment_method`) VALUES
(1, 'eto', 'Jane', 'jane.eto@gmail.com', '0786543210', '123 Main St', 'Credit Car'),
(2, 'Smith', 'Jane', 'jane.smith@gmail.com', '0786543210', '123 Main St', 'momo pay'),
(3, 'Niyonshuti', 'Jean Pierre', 'jeanpierreniyonshuti71@gmail.com', '0786543210', '250 R/KGL', 'mobile mon');

--
-- Triggers `customer`
--
DELIMITER $$
CREATE TRIGGER `AfterCustomerDelete` AFTER DELETE ON `customer` FOR EACH ROW BEGIN
    INSERT INTO customer_log (customer_id, action, timestamp)
    VALUES (OLD.customer_id, 'DELETE', NOW());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterCustomerInsert` AFTER INSERT ON `customer` FOR EACH ROW BEGIN
    INSERT INTO customer_log (customer_id, action, timestamp)
    VALUES (NEW.customer_id, 'INSERT', NOW());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterCustomerUpdate` AFTER UPDATE ON `customer` FOR EACH ROW BEGIN
    INSERT INTO customer_log (customer_id, action, timestamp)
    VALUES (NEW.customer_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customers_id` int(11) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `emai` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `payment_method` varchar(255) DEFAULT 'Default Payment Method'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customers_id`, `last_name`, `first_name`, `emai`, `phone`, `address`, `payment_method`) VALUES
(3, 'derrr', 'felix', 'de33', '2345', 'sf', NULL),
(5, 'ruda', 'fw', 'werdfgh', '50', 'ihjij', NULL),
(6, 'joe felix', 'berbatov', '@bertov', '0788888', 'rd45', 'MTN'),
(7, 'ENOCK', 'AMAN', '344GF', '0788988', 'GCVGHUV', 'TIGO'),
(10, 'gad', 'shema', 'we', '0788888', '54', 'A$MBANK');

-- --------------------------------------------------------

--
-- Table structure for table `customer_to_delete`
--

CREATE TABLE `customer_to_delete` (
  `customer_id` int(11) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `emai` varchar(100) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `payment_method` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_to_deletes`
--

CREATE TABLE `customer_to_deletes` (
  `customer_id` int(11) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `emai` varchar(100) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `payment_method` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `licence_number` varchar(20) NOT NULL,
  `vehicle_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driver_id`, `first_name`, `last_name`, `phone`, `licence_number`, `vehicle_id`) VALUES
(1, 'alice', 'tumukunde', '0785432199', 'DL123456', 3),
(2, 'Michael', 'IRAKOZE', '0795432109', 'DL199456', 2),
(3, 'peter', 'emm', '456', '345', 3),
(7, 'felix', 'joe', '07888888', '4444', 4),
(8, 'kwizera', 'felixxx', '08776565', '3546', 4),
(9, '', '', '', '', 4);

--
-- Triggers `driver`
--
DELIMITER $$
CREATE TRIGGER `AfterDriverUpdate` AFTER UPDATE ON `driver` FOR EACH ROW BEGIN
    INSERT INTO driver_log (driver_id, action, action_date)
    VALUES (NEW.driver_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `driver_log`
--

CREATE TABLE `driver_log` (
  `id` int(11) NOT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver_log`
--

INSERT INTO `driver_log` (`id`, `driver_id`, `action`, `action_date`) VALUES
(1, 1, 'UPDATE', '2024-02-17 09:13:29'),
(2, 1, 'UPDATE', '2024-02-17 09:13:48'),
(3, 4, 'UPDATE', '2024-02-17 11:04:20'),
(4, 4, 'UPDATE', '2024-02-17 11:04:31'),
(5, 3, 'UPDATE', '2024-02-17 11:05:19');

-- --------------------------------------------------------

--
-- Table structure for table `fuel_admin`
--

CREATE TABLE `fuel_admin` (
  `adm_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phon_number` varchar(10) NOT NULL,
  `permissions` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fuel_admin`
--

INSERT INTO `fuel_admin` (`adm_id`, `email`, `Password`, `first_name`, `last_name`, `phon_number`, `permissions`) VALUES
(1, 'felix@gmail.com', '222005550', 'felix', 'kwizera', '0786543210', 'ALL'),
(2, 'luka@gmail.com', '222000745', 'kiza', 'alex', '0726543210', 'ALL'),
(3, 'admin@gmail.com', '33333000', 'odeta', 'akaliza', '0796543210', 'ALL');

-- --------------------------------------------------------

--
-- Table structure for table `fuel_deliveryorders`
--

CREATE TABLE `fuel_deliveryorders` (
  `fueldelorder_id` int(11) NOT NULL,
  `fuelsup_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fuel_deliveryorders`
--

INSERT INTO `fuel_deliveryorders` (`fueldelorder_id`, `fuelsup_id`, `order_id`, `date_delivered`) VALUES
(1, 1, 1, '2023-04-15'),
(2, 2, 3, '2023-08-31'),
(3, 3, 3, '2023-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `fuel_deliveryrecord`
--

CREATE TABLE `fuel_deliveryrecord` (
  `fueldelrecord_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `fuelsta_id` int(11) DEFAULT NULL,
  `quentity` int(11) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fuel_deliveryrecord`
--

INSERT INTO `fuel_deliveryrecord` (`fueldelrecord_id`, `order_id`, `driver_id`, `fuelsta_id`, `quentity`, `date_delivered`) VALUES
(1, 1, 1, 1, 50, '2023-08-31'),
(2, 2, 3, 1, 150, '2023-08-11'),
(3, 3, 1, 2, 250, '2023-08-22');

-- --------------------------------------------------------

--
-- Table structure for table `fuel_station`
--

CREATE TABLE `fuel_station` (
  `fuelsta_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `fuel_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `fuel_suppler`
--

CREATE TABLE `fuel_suppler` (
  `fuelsup_id` int(11) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fuel_suppler`
--
ALTER TABLE `fuel_suppler`
  ADD PRIMARY KEY (`fuelsup_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fuel_suppler`
--
ALTER TABLE `fuel_suppler`
  MODIFY `fuelsup_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
