-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 18, 2022 at 12:43 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Polypro`
--

-- --------------------------------------------------------

--
-- Table structure for table `chuyenDe`
--

CREATE TABLE `chuyenDe` (
  `id` int(11) NOT NULL,
  `tenCD` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hocPhi` double DEFAULT NULL,
  `thoiLuong` int(11) DEFAULT NULL,
  `moTa` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chuyenDe`
--

INSERT INTO `chuyenDe` (`id`, `tenCD`, `hocPhi`, `thoiLuong`, `moTa`, `status`) VALUES
(1, 'SQL', 222222, 2, '123', 1),
(2, 'Java', 1000000, 3, 'JavaPro1', 1),
(3, 'test', 1231412, 90, 'thanh tets 1', 0),
(4, 'C++', 67456, 60, 'Lập trình C++', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hocVien`
--

CREATE TABLE `hocVien` (
  `id` int(11) NOT NULL,
  `idKH` int(11) DEFAULT NULL,
  `idNH` int(11) DEFAULT NULL,
  `diem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hocVien`
--

INSERT INTO `hocVien` (`id`, `idKH`, `idNH`, `diem`) VALUES
(23, 8, 1, 2),
(25, 16, 3, 1),
(26, 8, 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `khoaHoc`
--

CREATE TABLE `khoaHoc` (
  `id` int(11) NOT NULL,
  `idCD` int(11) NOT NULL,
  `hocPhi` double DEFAULT NULL,
  `thoiLuong` int(11) DEFAULT NULL,
  `ngayKG` date DEFAULT NULL,
  `ghiChu` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `idNV` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `tenKH` varchar(200) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoaHoc`
--

INSERT INTO `khoaHoc` (`id`, `idCD`, `hocPhi`, `thoiLuong`, `ngayKG`, `ghiChu`, `ngayTao`, `idNV`, `status`, `tenKH`) VALUES
(8, 1, 222222, 2, '2022-05-04', '11111', '2022-05-19', 4, 1, 'SQL Server'),
(10, 2, 1000000, 3, '2022-05-19', 'lập trình java core', '2022-05-23', 4, 0, 'Java 1'),
(13, 2, NULL, NULL, NULL, 'adsa', '2022-05-11', NULL, 0, 'Java 1'),
(14, 2, NULL, NULL, NULL, 'ad', '2022-05-23', NULL, 0, 'Java 1'),
(15, 2, 1000000, 3, '2022-05-13', '123', '2022-05-23', 4, 1, 'Java2'),
(16, 2, 1000000, 3, '2022-05-02', '111', '2022-05-23', 4, 1, 'Java1'),
(17, 2, 1000000, 3, '2022-05-02', '111', '2022-05-23', 4, 1, 'Java5'),
(18, 2, 1000000, 3, '2022-05-12', 'a', '2022-05-23', 4, 1, 'Java7'),
(19, 4, 67456, 60, '2022-05-12', 'Lập trình C++', '2022-05-23', 4, 1, 'C++ 1');

-- --------------------------------------------------------

--
-- Table structure for table `nguoiHoc`
--

CREATE TABLE `nguoiHoc` (
  `id` int(11) NOT NULL,
  `hoTen` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` tinyint(1) DEFAULT NULL,
  `sdt` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ghiChu` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `idNV` int(11) DEFAULT NULL,
  `ngayDK` date DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nguoiHoc`
--

INSERT INTO `nguoiHoc` (`id`, `hoTen`, `ngaySinh`, `gioiTinh`, `sdt`, `email`, `ghiChu`, `idNV`, `ngayDK`, `status`) VALUES
(1, 'Trằn Văn Thành1', '2022-05-02', 1, '0385613085', 'vanthanh10012k@gmail.com', '123', 4, '2022-05-19', 1),
(2, 'ThongPro', '2022-05-13', 1, '123456789', 'thong@gmail.com', 'ok', 4, '2022-05-19', 1),
(3, 'Trần Minh Sáng 123', '2022-05-03', 1, '1312312', 'ok@gmail.com', '111111111', 4, '2022-05-19', 1),
(4, 'Vuong', '2022-05-03', 1, '0385613033', 'vuong@gmail.com', '111111', 4, '2022-05-19', 1),
(5, 'Trằn Văn Thành', '2022-05-11', 1, '0385613085123', 'thanhtvph15015@gmail.com', 'thanh ', 4, '2022-05-23', 1),
(6, 'Phạm Đức Mạnh', '2022-05-18', 1, '1312312412465', 'thanhtvph15014@gmail.com', 'Mạnh dz', 4, '2022-05-23', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanVien`
--

CREATE TABLE `nhanVien` (
  `id` int(11) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `matKhau` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `hoTen` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `vaiTro` int(11) DEFAULT 0,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanVien`
--

INSERT INTO `nhanVien` (`id`, `email`, `matKhau`, `hoTen`, `vaiTro`, `status`) VALUES
(1, 'thanhngu@gmail.com', '$2a$10$Io497mnKYctRCwRTdfIbVOub84e.xiNLJzvgn3Hu9XPxHXF/OY72K', 'Trằn Văn Thành', 0, 1),
(4, 'sang@gmail.com', '$2a$10$4tlkX.zVol3SMi88gflhTeQmjmtWhHQC0NkCGUc1jCZCMAYNhVfhy', 'Trần Minh Sáng', 1, 1),
(6, 'thanhtvph15015@gmail.com', '$2a$10$U6a9c2RBBfowRUwPdpy8ROfX4/sS8kPaj6WPsHFNkArfWvoC0uhJy', 'Viết Tiến Vuong', 0, 1),
(7, 'thanhtvph15014@gmail.com', '$2a$10$HWJZZDS0mpCYk.nyn8hOjuYBVY2hi2WnVsSM/A27FAs3W8gD0RGZy', 'P D Mạnh', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuyenDe`
--
ALTER TABLE `chuyenDe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hocVien`
--
ALTER TABLE `hocVien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hocVien_khoaHoc_id_fk` (`idKH`),
  ADD KEY `hocVien_nguoiHoc_id_fk` (`idNH`);

--
-- Indexes for table `khoaHoc`
--
ALTER TABLE `khoaHoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `khoaHoc_nhanVien_id_fk` (`idNV`),
  ADD KEY `FK13qmrebckqal77g0jpv80mrva` (`idCD`);

--
-- Indexes for table `nguoiHoc`
--
ALTER TABLE `nguoiHoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nguoiHoc_nhanVien_id_fk` (`idNV`);

--
-- Indexes for table `nhanVien`
--
ALTER TABLE `nhanVien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chuyenDe`
--
ALTER TABLE `chuyenDe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hocVien`
--
ALTER TABLE `hocVien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `khoaHoc`
--
ALTER TABLE `khoaHoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `nguoiHoc`
--
ALTER TABLE `nguoiHoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `nhanVien`
--
ALTER TABLE `nhanVien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hocVien`
--
ALTER TABLE `hocVien`
  ADD CONSTRAINT `hocVien_khoaHoc_id_fk` FOREIGN KEY (`idKH`) REFERENCES `khoaHoc` (`id`),
  ADD CONSTRAINT `hocVien_nguoiHoc_id_fk` FOREIGN KEY (`idNH`) REFERENCES `nguoiHoc` (`id`);

--
-- Constraints for table `khoaHoc`
--
ALTER TABLE `khoaHoc`
  ADD CONSTRAINT `FK13qmrebckqal77g0jpv80mrva` FOREIGN KEY (`idCD`) REFERENCES `chuyenDe` (`id`),
  ADD CONSTRAINT `khoaHoc_nhanVien_id_fk` FOREIGN KEY (`idNV`) REFERENCES `nhanVien` (`id`);

--
-- Constraints for table `nguoiHoc`
--
ALTER TABLE `nguoiHoc`
  ADD CONSTRAINT `nguoiHoc_nhanVien_id_fk` FOREIGN KEY (`idNV`) REFERENCES `nhanVien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
