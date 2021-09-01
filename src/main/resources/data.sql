INSERT INTO customers (customer_id, title, first_name, last_name,gender) VALUES
  ('00123285', 'Mr', 'test', 'testlast', 'male'),
  ('00123987', 'Miss', 'sample', 'samplelast', 'female');

INSERT INTO accounts (account_no, bsb, name, balance, customer_id) VALUES
  (12345, '923100', 'OE', 10000.12, '00123285'),
  (56789, '923100', 'SM', 2000.20, '00123285');