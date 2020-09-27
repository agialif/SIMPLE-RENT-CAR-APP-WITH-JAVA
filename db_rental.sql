-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2018 at 08:37 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE `tb_login` (
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`username`, `pass`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mobil`
--

CREATE TABLE `tb_mobil` (
  `id_mobil` varchar(4) NOT NULL,
  `nama_mobil` varchar(20) DEFAULT NULL,
  `merek_mobil` varchar(20) DEFAULT NULL,
  `harga_rental` bigint(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mobil`
--

INSERT INTO `tb_mobil` (`id_mobil`, `nama_mobil`, `merek_mobil`, `harga_rental`, `status`) VALUES
('a001', 'avanza', 'toyota', 100000, 'READY'),
('a002', 'xenia', 'toyota', 120000, 'READY'),
('a003', 'rush', 'toyota', 150000, 'READY'),
('a01', 'terios', 'toyota', 120000, 'READY'),
('a02', 'sienta', 'toyota', 130000, 'READY');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `id_pengembalian` varchar(10) NOT NULL,
  `id_rental` varchar(10) DEFAULT NULL,
  `id_penyewa` varchar(10) DEFAULT NULL,
  `id_mobil` varchar(10) DEFAULT NULL,
  `tgl_rental` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `lama` bigint(3) DEFAULT NULL,
  `total_bayar` bigint(8) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `denda` bigint(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`id_pengembalian`, `id_rental`, `id_penyewa`, `id_mobil`, `tgl_rental`, `tgl_kembali`, `lama`, `total_bayar`, `status`, `denda`) VALUES
('null', 'a34', 'a11', 'sienta', '2018-12-05', '2018-12-06', 1, 470000, 'KEMBALI', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `id_penyewa` varchar(20) NOT NULL,
  `nama_penyewa` varchar(25) DEFAULT NULL,
  `alamat` varchar(25) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `no_ktp` varchar(16) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_rental`
--

CREATE TABLE `tb_rental` (
  `id_rental` varchar(10) NOT NULL,
  `id_penyewa` varchar(10) DEFAULT NULL,
  `id_mobil` varchar(10) DEFAULT NULL,
  `nama_penyewa` varchar(25) DEFAULT NULL,
  `nama_mobil` varchar(10) DEFAULT NULL,
  `harga_rental` bigint(10) DEFAULT NULL,
  `tgl_rental` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `total` bigint(8) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_rental`
--

INSERT INTO `tb_rental` (`id_rental`, `id_penyewa`, `id_mobil`, `nama_penyewa`, `nama_mobil`, `harga_rental`, `tgl_rental`, `tgl_kembali`, `total`, `status`) VALUES
('32e2', 'b003', 'avanza', 'agi', 'a001', 100000, '2018-12-07', '2018-12-09', 250000, 'SELESAI'),
('c004', 'd06', 'xenia', 'ksdhkdh', 'a002', 120000, '2018-12-07', '2018-12-10', 410000, 'SELESAI'),
('c008', 'b0010', 'rush', 'justin', 'a003', 150000, '2018-12-14', '2018-12-15', 150000, 'SELESAI'),
('c01', 'PILIH', 'terios', 'Agi', 'PILIH', 120000, '2018-12-07', '2018-12-08', 170000, 'SELESAI'),
('c02', 'b02', 'avanza', 'ajah', 'a001', 100000, '2018-12-08', '2018-12-09', 150000, 'SELESAI'),
('c03', 'b03', 'xenia', 'nbb', 'a002', 120000, '2018-12-01', '2018-12-02', 170000, 'SELESAI'),
('a34', 'a11', 'sienta', 'abcd', 'a02', 130000, '2018-12-02', '2018-12-05', 440000, 'SELESAI'),
('', 'a12', 'a001', 'hjghjf', 'avanza', 100000, '2018-12-12', '2018-12-13', 150000, 'SEWA'),
('c011', 'PILIH', 'terios', 'Agi', 'PILIH', 120000, '2018-12-12', '2018-12-13', 170000, 'SELESAI'),
('', 'a13', 'a002', 'hjhj', 'xenia', 120000, '2018-12-25', '2018-12-26', 170000, 'SEWA'),
('c01111', 'PILIH', 'terios', 'hjhj', 'PILIH', 120000, '2018-12-12', '2018-12-26', 170000, 'SEWA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian` ADD FULLTEXT KEY `id_pengembalian` (`id_pengembalian`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indexes for table `tb_rental`
--
ALTER TABLE `tb_rental` ADD FULLTEXT KEY `id_rental` (`id_rental`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
