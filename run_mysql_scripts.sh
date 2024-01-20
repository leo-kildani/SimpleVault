read -p "Enter MySQL username: " DB_USER
read -s -p "Enter MySQL password: " DB_PASSWORD
echo

cd src/main/resources/scripts

for file in *.sql; do
    mysql -u$DB_USER -p$DB_PASSWORD < "$file"
done