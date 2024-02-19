-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2024 at 05:40 PM
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
-- Database: `graduate_student_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(200) DEFAULT NULL,
  `lname` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `martial_status` varchar(200) DEFAULT NULL,
  `DoB` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('gcgcg', 'bnncn', '07899899888', 'Male', 'singlr', '2000', 'hgfgh', 'vvvb'),
('', '', '', 'Male', '', '', '', ''),
('ddddddd', 'bbbbb', '078890000000', 'Male', 'single', '2001_01_17', 'bddd@gmail.com', 'MUHAZI'),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `applicant_info`
--

CREATE TABLE `applicant_info` (
  `applicant_info_id` int(11) NOT NULL,
  `father_name` varchar(255) NOT NULL,
  `mother_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(70) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicant_info`
--

INSERT INTO `applicant_info` (`applicant_info_id`, `father_name`, `mother_name`, `email`, `phone`, `address`, `age`) VALUES
(1, 'muneza', 'golorie', 'fdjfhdfhd@gmail.com', '072123323', 'butare', 23),
(2, 'kalisa', 'domina', 'eric@gmail.com', '0798877565', 'gasb0', 28),
(3, 'ezer', 'munyana', 'petre@gmail.com', '078671223', 'kabarore', 22);

-- --------------------------------------------------------

--
-- Table structure for table `course_info`
--

CREATE TABLE `course_info` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_title` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `credits_number` int(11) NOT NULL,
  `semester_offered` varchar(50) NOT NULL,
  `grade` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course_info`
--

INSERT INTO `course_info` (`course_id`, `student_id`, `course_title`, `department`, `credits_number`, `semester_offered`, `grade`) VALUES
(1, 1, 'JAVA', 'BIT', 15, '1', 'A'),
(2, 4, 'bzness mgt', 'BIT', 10, '1', 'B'),
(3, 1, 'economics', 'acc', 20, '2', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `financial_issues_info`
--

CREATE TABLE `financial_issues_info` (
  `financial_info_id` int(11) NOT NULL,
  `school_fees` varchar(200) NOT NULL,
  `library_status` varchar(50) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `financial_issues_info`
--

INSERT INTO `financial_issues_info` (`financial_info_id`, `school_fees`, `library_status`, `student_id`) VALUES
(1, 'Cleared', 'Not Cleared', 4),
(2, 'Not Cleared', 'Cleared', 1),
(4, 'Cleared', 'Cleared', 1);

-- --------------------------------------------------------

--
-- Table structure for table `project_research_info`
--

CREATE TABLE `project_research_info` (
  `project_id` int(11) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `project_purpose` varchar(255) NOT NULL,
  `student_id` int(11) NOT NULL,
  `project_invigilator_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_research_info`
--

INSERT INTO `project_research_info` (`project_id`, `project_name`, `project_purpose`, `student_id`, `project_invigilator_name`) VALUES
(1, 'nursing project', 'to care patient', 1, 'emmy'),
(2, 'e-commerce project', 'to buy and sell goods', 4, 'jmv'),
(3, 'system of study ', 'well study', 4, 'bela');

-- --------------------------------------------------------

--
-- Table structure for table `semester_info`
--

CREATE TABLE `semester_info` (
  `semester_info_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `ending_date` date NOT NULL,
  `student_id` int(11) NOT NULL,
  `semester_code` varchar(50) NOT NULL,
  `total_number_of_modules` int(11) NOT NULL,
  `failed_modules` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester_info`
--

INSERT INTO `semester_info` (`semester_info_id`, `start_date`, `ending_date`, `student_id`, `semester_code`, `total_number_of_modules`, `failed_modules`) VALUES
(1, '2023-08-07', '2024-02-10', 4, '2', 14, 4),
(2, '2022-08-07', '2023-02-10', 1, '3', 17, 2);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `date_of_birth`, `email`, `phone_number`, `gender`) VALUES
(1, 'elyze', 'mugisha', '2000-01-02', 'elyz@gmail.com', '079899998', 'Male'),
(4, 'ndiho', 'ben', '2004-01-03', 'GG@gmail.com', '079899998', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicant_info`
--
ALTER TABLE `applicant_info`
  ADD PRIMARY KEY (`applicant_info_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `course_info`
--
ALTER TABLE `course_info`
  ADD PRIMARY KEY (`course_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `financial_issues_info`
--
ALTER TABLE `financial_issues_info`
  ADD PRIMARY KEY (`financial_info_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `project_research_info`
--
ALTER TABLE `project_research_info`
  ADD PRIMARY KEY (`project_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `semester_info`
--
ALTER TABLE `semester_info`
  ADD PRIMARY KEY (`semester_info_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applicant_info`
--
ALTER TABLE `applicant_info`
  MODIFY `applicant_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `course_info`
--
ALTER TABLE `course_info`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `financial_issues_info`
--
ALTER TABLE `financial_issues_info`
  MODIFY `financial_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `project_research_info`
--
ALTER TABLE `project_research_info`
  MODIFY `project_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `semester_info`
--
ALTER TABLE `semester_info`
  MODIFY `semester_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course_info`
--
ALTER TABLE `course_info`
  ADD CONSTRAINT `course_info_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `financial_issues_info`
--
ALTER TABLE `financial_issues_info`
  ADD CONSTRAINT `financial_issues_info_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `project_research_info`
--
ALTER TABLE `project_research_info`
  ADD CONSTRAINT `project_research_info_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `semester_info`
--
ALTER TABLE `semester_info`
  ADD CONSTRAINT `semester_info_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
