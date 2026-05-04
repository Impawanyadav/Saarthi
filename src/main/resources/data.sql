-- =========================
-- USERS (20 users)
-- =========================
INSERT INTO user (id, name, age, gender, email, password) VALUES
(1, 'Aarav Sharma', 22, 'Male', 'aarav@gmail.com', 'pass123'),
(2, 'Isha Verma', 21, 'Female', 'isha@gmail.com', 'pass123'),
(3, 'Rohan Gupta', 24, 'Male', 'rohan@gmail.com', 'pass123'),
(4, 'Neha Singh', 23, 'Female', 'neha@gmail.com', 'pass123'),
(5, 'Aditya Kumar', 25, 'Male', 'aditya@gmail.com', 'pass123'),
(6, 'Priya Patel', 22, 'Female', 'priya@gmail.com', 'pass123'),
(7, 'Karan Yadav', 26, 'Male', 'karan@gmail.com', 'pass123'),
(8, 'Sneha Joshi', 21, 'Female', 'sneha@gmail.com', 'pass123'),
(9, 'Mohit Agarwal', 24, 'Male', 'mohit@gmail.com', 'pass123'),
(10, 'Ananya Tiwari', 22, 'Female', 'ananya@gmail.com', 'pass123'),
(11, 'Vikram Singh', 27, 'Male', 'vikram@gmail.com', 'pass123'),
(12, 'Simran Kaur', 23, 'Female', 'simran@gmail.com', 'pass123'),
(13, 'Rahul Mehta', 25, 'Male', 'rahul@gmail.com', 'pass123'),
(14, 'Pooja Sharma', 22, 'Female', 'pooja@gmail.com', 'pass123'),
(15, 'Arjun Verma', 24, 'Male', 'arjun@gmail.com', 'pass123'),
(16, 'Deepak Yadav', 26, 'Male', 'deepak@gmail.com', 'pass123'),
(17, 'Meera Joshi', 21, 'Female', 'meera@gmail.com', 'pass123'),
(18, 'Nitin Bansal', 25, 'Male', 'nitin@gmail.com', 'pass123'),
(19, 'Shivani Gupta', 22, 'Female', 'shivani@gmail.com', 'pass123'),
(20, 'Harsh Vardhan', 27, 'Male', 'harsh@gmail.com', 'pass123');


-- =========================
-- ROOMS (6 entries)
-- =========================
INSERT INTO room (
id, name, phone, aadhaar, email,
room_type, price, room_details,
city, state, address, pincode,
likes, status, user_id
) VALUES

(1, 'Aarav Sharma', 9876500001, '111122223333', 'aarav@gmail.com',
'Single Room', '5000', 'Basic single room',
'Lucknow', 'UP', 'Gomti Nagar', '226010',
10, 'Available', 1),

(2, 'Isha Verma', 9876500002, '111122223334', 'isha@gmail.com',
'PG (Paying Guest)', '6000', 'PG with food',
'Lucknow', 'UP', 'Aliganj', '226024',
15, 'Available', 2),

(3, 'Rohan Gupta', 9876500003, '111122223335', 'rohan@gmail.com',
'1BHK', '12000', 'Furnished 1BHK',
'Delhi', 'Delhi', 'Lajpat Nagar', '110024',
8, 'Occupied', 3),

(4, 'Neha Singh', 9876500004, '111122223336', 'neha@gmail.com',
'2BHK', '18000', 'Family flat',
'Noida', 'UP', 'Sector 62', '201301',
12, 'Available', 4),

(5, 'Aditya Kumar', 9876500005, '111122223337', 'aditya@gmail.com',
'Hostel Room', '3000', 'Shared hostel',
'Kanpur', 'UP', 'Civil Lines', '208001',
5, 'Available', 5),

(6, 'Priya Patel', 9876500006, '111122223338', 'priya@gmail.com',
'1RK', '7000', 'Room + kitchen',
'Lucknow', 'UP', 'Indira Nagar', '226016',
7, 'Available', 6);


-- =========================
-- WORKERS (6 entries)
-- =========================
INSERT INTO worker (
id, name, phone, email, aadhaar,
work, description, gender,
likes, status, city, state, user_id
) VALUES

(1, 'Aarav Sharma', 9876500001, 'aarav@gmail.com', '111122223333',
'Plumber', 'Pipe repair expert', 'Male',
10, 'Available', 'Lucknow', 'UP', 1),

(2, 'Isha Verma', 9876500002, 'isha@gmail.com', '111122223334',
'Electrician', 'Wiring expert', 'Female',
12, 'Available', 'Lucknow', 'UP', 2),

(3, 'Rohan Gupta', 9876500003, 'rohan@gmail.com', '111122223335',
'Carpenter', 'Wood work expert', 'Male',
7, 'Busy', 'Delhi', 'Delhi', 3),

(4, 'Neha Singh', 9876500004, 'neha@gmail.com', '111122223336',
'Cook / Chef', 'Home cooking service', 'Female',
9, 'Available', 'Kanpur', 'UP', 4),

(5, 'Aditya Kumar', 9876500005, 'aditya@gmail.com', '111122223337',
'Driver', 'Driving service', 'Male',
6, 'Available', 'Noida', 'UP', 5),

(6, 'Priya Patel', 9876500006, 'priya@gmail.com', '111122223338',
'Maid', 'House cleaning service', 'Female',
11, 'Available', 'Lucknow', 'UP', 6);


-- =========================
-- LUNCH (6 entries)
-- =========================
INSERT INTO lunch (
id, name, phone, aadhaar, email,
menu_price, city, state, address, pincode,
likes, status, user_id
) VALUES

(1, 'Aarav Sharma', '9876500001', '111122223333', 'aarav@gmail.com',
'Daily 100', 'Lucknow', 'UP', 'Gomti Nagar', '226010',
5, 'Available', 1),

(2, 'Isha Verma', '9876500002', '111122223334', 'isha@gmail.com',
'Daily 120', 'Lucknow', 'UP', 'Aliganj', '226024',
6, 'Available', 2),

(3, 'Rohan Gupta', '9876500003', '111122223335', 'rohan@gmail.com',
'Daily 150', 'Delhi', 'Delhi', 'Lajpat Nagar', '110024',
7, 'Available', 3),

(4, 'Neha Singh', '9876500004', '111122223336', 'neha@gmail.com',
'Daily 110', 'Kanpur', 'UP', 'Civil Lines', '208001',
4, 'Available', 4),

(5, 'Aditya Kumar', '9876500005', '111122223337', 'aditya@gmail.com',
'Daily 130', 'Noida', 'UP', 'Sector 62', '201301',
8, 'Available', 5),

(6, 'Priya Patel', '9876500006', '111122223338', 'priya@gmail.com',
'Daily 140', 'Lucknow', 'UP', 'Indira Nagar', '226016',
9, 'Available', 6);


-- =========================
-- DAIRY (6 entries)
-- =========================
INSERT INTO dairy (
id, name, phone, aadhaar, email,
menu_price, city, state, address, pincode,
likes, status, user_id
) VALUES

(1, 'Aarav Sharma', 9876500001, '111122223333', 'aarav@gmail.com',
'MILK 50/L', 'Lucknow', 'UP', 'Gomti Nagar', '226010',
3, 'Available', 1),

(2, 'Isha Verma', 9876500002, '111122223334', 'isha@gmail.com',
'MILK 55/L', 'Lucknow', 'UP', 'Aliganj', '226024',
4, 'Available', 2),

(3, 'Rohan Gupta', 9876500003, '111122223335', 'rohan@gmail.com',
'MILK 52/L', 'Delhi', 'Delhi', 'Lajpat Nagar', '110024',
5, 'Available', 3),

(4, 'Neha Singh', 9876500004, '111122223336', 'neha@gmail.com',
'MILK 50/L', 'Kanpur', 'UP', 'Civil Lines', '208001',
2, 'Available', 4),

(5, 'Aditya Kumar', 9876500005, '111122223337', 'aditya@gmail.com',
'MILK 60/L', 'Noida', 'UP', 'Sector 62', '201301',
6, 'Available', 5),

(6, 'Priya Patel', 9876500006, '9876500006', 'priya@gmail.com',
'MILK 58/L', 'Lucknow', 'UP', 'Indira Nagar', '226016',
7, 'Available', 6);