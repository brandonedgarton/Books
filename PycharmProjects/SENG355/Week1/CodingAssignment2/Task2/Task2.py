import csv

def read_csv(file_path):
    with open(file_path, 'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        data = [row for row in reader]
    return header, data

def print_all(file_path):
    header, data = read_csv(file_path)
    print("All file contents:")
    print(header)
    for row in data:
        print(row)

def print_n_records(file_path, n):
    header, data = read_csv(file_path)
    print(f"Printing the first {n} records:")
    print(header)
    for row in data[:n]:
        print(row)

def print_summary(file_path):
    header, data = read_csv(file_path)

    num_records = len(data)

    prices = [float(row[1]) for row in data]
    most_expensive = max(data, key=lambda x: float(x[1]))
    least_expensive = min(data, key=lambda x: float(x[1]))

    print("Summary Information:")
    print(f"Number of records: {num_records}")
    print(f"Most expensive house details: {most_expensive}")
    print(f"Least expensive house details: {least_expensive}")

    save_summary(file_path, num_records, most_expensive, least_expensive)

def print_prices_above_n(file_path, n):
    header, data = read_csv(file_path)
    print(f"Printing house prices above {n}:")
    for row in data:
        if float(row[1]) > n:
            print(f"House {row[0]} price: {row[1]}")

def print_houses_with_n_bedrooms(file_path, n):
    header, data = read_csv(file_path)
    print(f"Printing houses with {n} bedrooms:")
    for row in data:
        if int(row[2]) == n:
            print(f"House {row[0]} details: {row}")

def save_summary(file_path, num_records, most_expensive, least_expensive):
    with open("summary.txt", 'w') as file:
        file.write(f"Number of records: {num_records}\n")
        file.write(f"Most expensive house details: {most_expensive}\n")
        file.write(f"Least expensive house details: {least_expensive}\n")

def main():
    file_path = input("Enter the CSV file path: ")

    while True:
        print("\nMenu:")
        print("A) Print all file contents")
        print("B) Print n first records")
        print("C) Print summary information")
        print("D) Print house prices above n")
        print("E) Print houses with n bedrooms")
        print("Q) Quit")

        choice = input("Enter your choice: ").upper()

        if choice == 'A':
            print_all(file_path)
        elif choice == 'B':
            n = int(input("Enter the number of records to print: "))
            print_n_records(file_path, n)
        elif choice == 'C':
            print_summary(file_path)
        elif choice == 'D':
            n = float(input("Enter the threshold price: "))
            print_prices_above_n(file_path, n)
        elif choice == 'E':
            n = int(input("Enter the number of bedrooms: "))
            print_houses_with_n_bedrooms(file_path, n)
        elif choice == 'Q':
            print("Exiting the program.")
            break
        else:
            print("Invalid choice. Please enter a valid option.")

if __name__ == "__main__":
    main()
