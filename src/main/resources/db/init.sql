DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id                VARCHAR(30) NOT NULL PRIMARY KEY,
  name              VARCHAR(50) NOT NULL,
  stock          INTEGER NOT NULL,
  pricePerUnit      DOUBLE NOT NULL,
  weightInGrams     BIGINT NOT NULL
);

create TABLE coverage (
    fromPostalCode VARCHAR(10) NOT NULL,
    toPostalCode VARCHAR(10) NOT NULL,
    matrix_id INTEGER NOT NULL,
    deliveryDays INTEGER NOT NULL,
    deliveryDayPrime INTEGER NOT NULL
);

create table deliveryCharges (
  id INTEGER NOT NULL,
  eligiblityForFreeDelivery BIGINT NOT NULL,
  eligiblityForFreeDeliveryPrime BIGINT NOT NULL,
  deliveryCharges DOUBLE NOT NULL
);


INSERT INTO product VALUES (1, 'Toothpaste', 5000, 77, 100);
INSERT INTO product VALUES (2, 'HairOil', 3000, 48.50, 200);
INSERT INTO product VALUES (3, 'Shampoo', 100, 210, 350);
INSERT INTO product VALUES (4, 'Cream', 800, 126, 100);
INSERT INTO product VALUES (5, 'Apple', 200, 170, 1000);
INSERT INTO product VALUES (6, 'Mango', 700, 80, 1000);
INSERT INTO product VALUES (7, 'Water Melon', 800, 20, 1000);
INSERT INTO product VALUES (8, 'Paneer', 50, 400, 1000);
INSERT INTO product VALUES (9, 'Ghee', 120, 600, 970);
INSERT INTO product VALUES (10, 'Mustard Oil', 120, 600, 970);
INSERT INTO product VALUES (11, 'Milk-1L', 1021, 51, 1000);
INSERT INTO product VALUES (12, 'Milk-0.5L', 989, 26, 1000);
INSERT INTO product VALUES (13, 'Rice-Basmati', 2000, 120, 1000);
INSERT INTO product VALUES (14, 'Arhar Dal', 2000, 75, 1000);
INSERT INTO product VALUES (15, 'Wheat Flour-Aashirvaad', 345, 380, 10000);
INSERT INTO product VALUES (16, 'Water Cooler', 290, 15000, 25000);
INSERT INTO product VALUES (17, 'Refrigerator', 128, 35000, 30000);
INSERT INTO product VALUES (18, 'Air Conditioner', 200, 38000, 40000);
INSERT INTO product VALUES (19, 'Iphone X', 12, 80000, 750);
INSERT INTO product VALUES (20, 'Samsung Galaxy', 90, 72000, 800);
INSERT INTO product VALUES (21, 'SuitCase', 19, 6000, 3200);
INSERT INTO product VALUES (22, 'Apple MacBook Gen 8', 8, 150000, 4000);
INSERT INTO product VALUES (23, 'Haldiram Bhujia-200gms', 300 , 40, 210);
INSERT INTO product VALUES (24, 'Haldiram Bhujia-400gms', 130 , 76, 420);
INSERT INTO product VALUES (25, 'Haldiram Bhujia-1Kg', 45 , 180, 1000);


INSERT INTO deliveryCharges VALUES (1, 500, 100 , 30);
INSERT INTO deliveryCharges VALUES (2, 1000, 500 , 50);
INSERT INTO deliveryCharges VALUES (3, 5000, 1000 , 100);

INSERT INTO coverage VALUES (12121, 504293, 1, 1, 0);
INSERT INTO coverage VALUES (12121, 497118, 1, 1, 0);
INSERT INTO coverage VALUES (12121, 384245, 2, 2, 1);
INSERT INTO coverage VALUES (12121, 175105, 3, 3, 2);
INSERT INTO coverage VALUES (12121, 342332, 1, 1, 0);
INSERT INTO coverage VALUES (12121, 565454, 2, 2, 0);
INSERT INTO coverage VALUES (12121, 987876, 3, 3, 1);
