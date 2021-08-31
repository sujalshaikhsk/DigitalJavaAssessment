INSERT INTO customers (customer_id, first_name, last_name,gender) VALUES
  ('C123', 'test', 'lastname', 'F'),
  ('C987', 'sample', 'lastname', 'M');

INSERT INTO accounts (account_number, account_type, customer_id) VALUES
  (12345, 'SAVING', 'C123'),
  (56789, 'LOAN', 'C123');