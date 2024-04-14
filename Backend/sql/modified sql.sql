CREATE TABLE `SeatAvailability`(
    `SeatAvailabilityId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `RouteId` INT UNSIGNED NOT NULL,
    `ArrivalDate` DATE NOT NULL,
    `DepartureDate` DATE NOT NULL,
    `JourneyStartDate` DATE NOT NULL,
    `TrainCoachId` INT UNSIGNED NOT NULL,
    `SeatsAvailable` INT NOT NULL
);
CREATE TABLE `Admin`(
    `AdminId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `UserName` VARCHAR(255) NOT NULL,
    `Password` VARCHAR(255) NOT NULL
);
CREATE TABLE `Coach`(
    `CoachId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Type` VARCHAR(255) NOT NULL,
    `Seats` INT NOT NULL
);
CREATE TABLE `User`(
    `UserId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `UserName` VARCHAR(255) NOT NULL,
    `Email` VARCHAR(255) NOT NULL,
    `Address` VARCHAR(255) NOT NULL,
    `Gender` VARCHAR(255) NOT NULL,
    `Phone` BIGINT NOT NULL,
    `DoB` DATE NOT NULL,
    `Password` BIGINT NOT NULL
);
CREATE TABLE `TrainCoach`(
    `TrainCoachId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TrainId` INT UNSIGNED NOT NULL,
    `CoachId` INT UNSIGNED NOT NULL,
    `NoOfCoach` INT NOT NULL
);
CREATE TABLE `Train`(
    `TrainId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TrainName` VARCHAR(255) NOT NULL,
    `SourceStationId` INT UNSIGNED NOT NULL,
    `EndStationId` INT UNSIGNED NOT NULL,
    `TotalSeats` INT NOT NULL,
    `TotalCoaches` INT NOT NULL,
    `Days` INT NOT NULL,
    `CateringService` VARCHAR(255) NOT NULL
);
CREATE TABLE `Route`(
    `RouteId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TrainId` INT UNSIGNED NOT NULL,
    `StationId` INT UNSIGNED NOT NULL,
    `StopNumber` INT NOT NULL,
    `ArrivalTime` TIME NOT NULL,
    `DepartureTime` TIME NOT NULL,
    `PriceToNextStop` INT NOT NULL,
    `DistanceToNextStop` INT NOT NULL
);
CREATE TABLE `Booking`(
    `BookingId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `UserId` INT UNSIGNED NOT NULL,
    `Status` VARCHAR(255) NOT NULL,
    `BoardingStationId` INT UNSIGNED NOT NULL,
    `DestinationStationId` INT UNSIGNED NOT NULL,
    `TrainId` INT UNSIGNED NOT NULL,
    `PricePerTicket` INT NOT NULL,
    `NumberOfPassengers` INT NOT NULL
);
CREATE TABLE `Station`(
    `StationId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `StationName` VARCHAR(255) NOT NULL,
    `State` VARCHAR(255) NOT NULL
);
CREATE TABLE `Passenger`(
    `PassengerId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(255) NOT NULL,
    `Age` INT NOT NULL,
    `Gender` VARCHAR(255) NOT NULL,
    `BookingId` INT UNSIGNED NOT NULL,
    `SeatNumber` VARCHAR(255) NOT NULL,
    `Catering` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `Train` ADD CONSTRAINT `train_sourcestationid_foreign` FOREIGN KEY(`SourceStationId`) REFERENCES `Station`(`StationId`);

ALTER TABLE
    `Booking` ADD CONSTRAINT `booking_userid_foreign` FOREIGN KEY(`UserId`) REFERENCES `User`(`UserId`);
ALTER TABLE
    `TrainCoach` ADD CONSTRAINT `traincoach_coachid_foreign` FOREIGN KEY(`CoachId`) REFERENCES `Coach`(`CoachId`);
ALTER TABLE `Passenger` ADD INDEX `idx_catering` (`Catering`);
ALTER TABLE
    `Train` ADD CONSTRAINT `train_cateringservice_foreign` FOREIGN KEY(`CateringService`) REFERENCES `Passenger`(`Catering`);
ALTER TABLE
    `SeatAvailability` ADD CONSTRAINT `seatavailability_routeid_foreign` FOREIGN KEY(`RouteId`) REFERENCES `Route`(`RouteId`);
ALTER TABLE
    `Booking` ADD CONSTRAINT `booking_boardingstationid_foreign` FOREIGN KEY(`BoardingStationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Booking` ADD CONSTRAINT `booking_destinationstationid_foreign` FOREIGN KEY(`DestinationStationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Train` ADD CONSTRAINT `train_endstationid_foreign` FOREIGN KEY(`EndStationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `TrainCoach` ADD CONSTRAINT `traincoach_trainid_foreign` FOREIGN KEY(`TrainId`) REFERENCES `Train`(`TrainId`);
ALTER TABLE
    `SeatAvailability` ADD CONSTRAINT `seatavailability_traincoachid_foreign` FOREIGN KEY(`TrainCoachId`) REFERENCES `TrainCoach`(`TrainCoachId`);
ALTER TABLE
    `Passenger` ADD CONSTRAINT `passenger_bookingid_foreign` FOREIGN KEY(`BookingId`) REFERENCES `Booking`(`BookingId`);
ALTER TABLE
    `Booking` ADD CONSTRAINT `booking_trainid_foreign` FOREIGN KEY(`TrainId`) REFERENCES `Train`(`TrainId`);
ALTER TABLE
    `Route` ADD CONSTRAINT `route_stationid_foreign` FOREIGN KEY(`StationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Route` ADD CONSTRAINT `route_trainid_foreign` FOREIGN KEY(`TrainId`) REFERENCES `Train`(`TrainId`);