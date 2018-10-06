CREATE TABLE IF NOT EXISTS `UserEntity` (
    `userId` TEXT PRIMARY KEY NOT NULL,
    `userFirstName` TEXT,
    `userLastName` TEXT,
    `lastVisitDate` INTEGER,
    `role` INTEGER REFERENCES `RoleEntity` (`roleId`),
    `accountStatus` INTEGER,
    `comments` BLOB,
    `age` INTEGER NOT NULL)
{Params: []}
