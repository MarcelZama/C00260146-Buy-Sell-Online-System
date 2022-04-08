-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Апр 08 2022 г., 20:35
-- Версия сервера: 10.4.22-MariaDB
-- Версия PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `c00260146 buy/sell system`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cart`
--

CREATE TABLE `cart` (
  `cartid` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `Name_of_product` varchar(50) NOT NULL,
  `Quantity_in_stock` int(11) NOT NULL,
  `Selling_Price` decimal(11,2) NOT NULL,
  `Buying_Price` decimal(11,2) NOT NULL,
  `Voucher` decimal(11,2) NOT NULL,
  `Class` varchar(50) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL,
  `Name_of_product` varchar(50) NOT NULL,
  `Selling_Price` decimal(11,0) NOT NULL,
  `Class` varchar(50) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `Name_of_product` varchar(50) NOT NULL,
  `Quantity_in_stock` int(11) NOT NULL,
  `Selling_Price` decimal(11,2) NOT NULL,
  `Buying_Price` decimal(11,2) NOT NULL,
  `Voucher` decimal(11,2) NOT NULL,
  `Class` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`ID`, `Name_of_product`, `Quantity_in_stock`, `Selling_Price`, `Buying_Price`, `Voucher`, `Class`) VALUES
(1, 'Nintendo Wii Official Remote White', 5, '20.00', '9.00', '13.00', 'Gaming'),
(2, 'Taken 2008', 18, '1.00', '0.01', '0.01', 'Film/Tv'),
(3, 'Apple Iphone 8 32GB Black', 10, '170.00', '76.00', '102.00', 'Phones'),
(4, 'Apple Airpods 2nd Gen', 1, '130.00', '55.00', '78.00', 'Electronics'),
(5, '4 GB PC12800 DDR3 1600MHz 240 Pin Memory', 41, '8.00', '2.00', '2.00', 'Computing'),
(6, 'Red Dead Redemption 2', 2, '25.00', '10.00', '15.00', 'Gaming'),
(7, 'Samsung Galaxy S10 Dual Sim 128GB Prism Black', 3, '355.00', '195.00', '241.00', 'Phones'),
(8, 'Apple EarPods MMTN2ZM (Lightning Connector)', 18, '25.00', '13.00', '17.00', 'Electronics'),
(9, 'Hangover 2009', 46, '1.00', '0.01', '0.01', 'Film/Tv'),
(10, 'Generic USB Wired Optical Mouse', 5, '5.00', '1.20', '1.70', 'Computing'),
(11, 'FIFA 20', 4, '8.00', '1.30', '2.00', 'Gaming'),
(12, 'FIFA 18', 2, '3.00', '0.10', '0.20', 'Gaming'),
(13, 'Minecraft', 6, '35.00', '17.00', '23.00', 'Gaming'),
(14, 'Cyberpunk 2077', 3, '35.00', '15.00', '21.00', 'Gaming'),
(15, 'Battlefield 1', 1, '4.00', '1.00', '1.50', 'Gaming'),
(16, 'Apple iPhone XR 64GB Product Red', 5, '340.00', '187.00', '231.00', 'Phones'),
(17, 'Samsung Galaxy A20e Dual Sim 32GB Black', 6, '190.00', '104.00', '129.00', 'Phones'),
(18, 'Samsung Galaxy S20FE 5G Dual Sim 128GB Cloud Nav', 2, '430.00', '193.00', '258.00', 'Phones'),
(19, 'Apple iPhone 6S 32GB Space Grey', 4, '95.00', '42.00', '57.00', 'Phones'),
(20, 'Nokia 3310 (2017) Dark Blue', 4, '52.00', '22.00', '31.00', 'Phones'),
(21, 'Xiaomi Redmi 9AT (2GB+32GB) Carbon Gray', 6, '120.00', '66.00', '81.00', 'Phones'),
(22, 'Xiaomi Redmi Note 10 5G (4GB+128GB) Gray', 2, '235.00', '129.00', '159.00', 'Phones'),
(23, 'Samsung Galaxy A52s 5G Dual Sim (6GB+128GB)', 3, '370.00', '203.00', '251.00', 'Phones'),
(24, 'Alcatel 1066G', 7, '22.00', '9.00', '13.00', 'Phones'),
(25, 'Huawei P30 Pro Dual Sim 256GB Black', 3, '390.00', '214.00', '265.00', 'Phones'),
(26, 'Alcatel 1 (2021) 16GB Al Aqua', 14, '55.00', '24.00', '33.00', 'Phones'),
(27, 'Samsung Galaxy S9 64GB Midnight Black', 55, '285.00', '156.00', '193.00', 'Phones'),
(28, 'Alcatel 1S 2021', 2, '105.00', '57.00', '71.00', 'Phones'),
(29, 'Nokia 5.3 Dual Sim (4GB+64GB)', 14, '140.00', '63.00', '84.00', 'Phones'),
(30, 'Nokia 2.4 32GB', 2, '85.00', '38.00', '51.00', 'Phones'),
(31, 'Nokia C01 Plus 16GB Blue', 5, '62.00', '34.00', '42.00', 'Phones'),
(32, 'Xiaomi Redmi Note 10 5G (4GB+128GB) Gray', 3, '235.00', '129.00', '159.00', 'Phones'),
(33, 'Xiaomi Redmi Airdots 2', 2, '20.00', '8.00', '12.00', 'Electronics'),
(34, 'BOSCH 909 Dual S', 3, '35.00', '14.00', '24.00', 'Phones'),
(35, 'BOSCH 909 Dual', 4, '14.00', '5.00', '7.00', 'Phones'),
(36, 'Asus 8z', 3, '135.00', '50.00', '65.00', 'Phones'),
(37, 'Cat S32', 5, '55.00', '28.00', '35.00', 'Phones'),
(38, 'HTC Desire 20+', 6, '35.00', '17.00', '25.00', 'Phones'),
(39, 'Apple iPad 4th Gen', 5, '125.00', '68.00', '85.00', 'Phones'),
(40, 'Apple iPod Nano Video 3rd Generation 4GB', 3, '35.00', '15.00', '21.00', 'Phones'),
(41, 'Apple iPad 8th Gen (A2270) 10.2\" 32GB', 4, '380.00', '209.00', '258.00', 'Phones'),
(42, 'Apple Watch Magnetic Charging Cable (1m)', 4, '25.00', '10.00', '15.00', 'Electronics'),
(43, 'Watch SE (GPS) NO STRAP, Space Grey Aluminium', 5, '220.00', '121.00', '149.00', 'Electronics'),
(44, 'Samsung Galaxy A52s 5G Dual Sim (6GB+128GB)', 6, '300.00', '165.00', '204.00', 'Phones'),
(45, '1 TB SATA Hard Drive', 14, '12.00', '5.00', '7.00', 'Computing'),
(46, 'Apple 60W MacBook/Pro 13\" MagSafe', 41, '35.00', '15.00', '21.00', 'Computing'),
(47, '500 GB 2.5\" SATA Hard Drive', 6, '12.00', '2.00', '4.00', 'Computing'),
(48, 'Apple Wireless Keyboard (3rd Gen A1314), B', 5, '32.00', '13.00', '19.00', 'Computing'),
(49, 'Intel Core i5-4570 (3.2Hz) LGA1150', 1, '30.00', '12.00', '18.00', 'Computing'),
(50, 'AMD A10 7800 (3.5Ghz) FM2+', 6, '25.00', '10.00', '15.00', 'Computing'),
(51, 'Seagate Laptop Thin 500GB 2.5\" SATA', 7, '12.00', '5.00', '7.00', 'Computing'),
(52, 'Canon EF 75-300mm 1:4-5.6 III', 6, '155.00', '85.00', '105.00', 'Electronics'),
(53, 'Apple TV 3rd Gen (A1427/A1469), B', 6, '28.00', '12.00', '16.00', 'Electronics'),
(54, 'Google Chromecast Ultra W/ Power Ethernet Adapter', 3, '50.00', '27.00', '34.00', 'Electronics'),
(55, 'Lord Of The Rings, TTT, 2 Disc (12)', 7, '1.00', '0.01', '0.01', 'Film/Tv'),
(56, 'Batman - Dark Knight 2 Disc', 12, '3.00', '0.10', '0.20', 'Film/Tv'),
(57, 'Shaun Of The Dead', 15, '1.00', '0.01', '0.01', 'Film/Tv'),
(58, 'In Bruges', 18, '1.00', '0.01', '0.01', 'Film/Tv');

-- --------------------------------------------------------

--
-- Структура таблицы `transaction`
--

CREATE TABLE `transaction` (
  `TransactionID` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `oderid` int(11) NOT NULL,
  `Price` decimal(11,2) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `City/Town` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `eircode` varchar(11) NOT NULL,
  `voucherprice` double(11,2) NOT NULL,
  `voucherid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `first_name` varchar(250) NOT NULL,
  `last_name` varchar(250) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `mobile_number` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `voucher`
--

CREATE TABLE `voucher` (
  `ID` int(11) NOT NULL,
  `Voucher_number` varchar(11) NOT NULL,
  `Price` double(11,2) NOT NULL,
  `used` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `voucher`
--

INSERT INTO `voucher` (`ID`, `Voucher_number`, `Price`, `used`) VALUES
(2, '1', 60.00, 1),
(3, '000001', 412.00, 0),
(4, '000002', 44.00, 0),
(5, '000003', 23.00, 0),
(6, '3', 10.00, 0);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartid`);

--
-- Индексы таблицы `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cart`
--
ALTER TABLE `cart`
  MODIFY `cartid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT для таблицы `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `voucher`
--
ALTER TABLE `voucher`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
