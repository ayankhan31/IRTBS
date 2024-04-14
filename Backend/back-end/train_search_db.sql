CREATE TABLE `Train`(
    `TrainId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TrainName` VARCHAR(255) NOT NULL,
    `SourceStationId` INT UNSIGNED NOT NULL,
    `EndStationId` INT UNSIGNED NOT NULL,
    `TotalSeats` INT NOT NULL,
    `TotalCoaches` INT NOT NULL,
    `Days` VARCHAR(7) NOT NULL CHECK (DAYS REGEXP '^[0-1]{7}$'),
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

CREATE TABLE `SeatAvailability`(
    `SeatAvailabilityId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `RouteId` INT UNSIGNED NOT NULL,
    `ArrivalDate` DATE NOT NULL,
    `DepartureDate` DATE NOT NULL,
    `JourneyStartDate` DATE NOT NULL,
    `TrainCoachId` INT UNSIGNED NOT NULL,
    `SeatsAvailable` INT NOT NULL
);

CREATE TABLE `Station`(
    `StationId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `StationName` VARCHAR(255) NOT NULL,
    `State` VARCHAR(255) NOT NULL
);

CREATE TABLE `TrainCoach`(
    `TrainCoachId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TrainId` INT UNSIGNED NOT NULL,
    `CoachId` INT UNSIGNED NOT NULL,
    `NoOfCoach` INT NOT NULL
);

CREATE TABLE `Coach`(
    `CoachId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Type` VARCHAR(255) NOT NULL,
    `Seats` INT NOT NULL
);

ALTER TABLE
    `Train` ADD CONSTRAINT `train_sourcestationid_foreign` FOREIGN KEY(`SourceStationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Train` ADD CONSTRAINT `train_endstationid_foreign` FOREIGN KEY(`EndStationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Route` ADD CONSTRAINT `route_stationid_foreign` FOREIGN KEY(`StationId`) REFERENCES `Station`(`StationId`);
ALTER TABLE
    `Route` ADD CONSTRAINT `route_trainid_foreign` FOREIGN KEY(`TrainId`) REFERENCES `Train`(`TrainId`);
ALTER TABLE
    `SeatAvailability` ADD CONSTRAINT `seatavailability_routeid_foreign` FOREIGN KEY(`RouteId`) REFERENCES `Route`(`RouteId`);
ALTER TABLE
    `SeatAvailability` ADD CONSTRAINT `seatavailability_traincoachid_foreign` FOREIGN KEY(`TrainCoachId`) REFERENCES `TrainCoach`(`TrainCoachId`);
ALTER TABLE
    `TrainCoach` ADD CONSTRAINT `traincoach_trainid_foreign` FOREIGN KEY(`TrainId`) REFERENCES `Train`(`TrainId`);
ALTER TABLE
    `TrainCoach` ADD CONSTRAINT `traincoach_coachid_foreign` FOREIGN KEY(`CoachId`) REFERENCES `Coach`(`CoachId`);


