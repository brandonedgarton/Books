class Employee:
    def __init__(self, emp_name, emp_num):
        self.__employee_name = emp_name
        self.__employee_number = emp_num

    def set_employee_name(self, emp_name):
        self.__employee_name = emp_name

    def set_employee_number(self, emp_num):
        self.__employee_number = emp_num

    def get_employee_name(self):
        return self.__employee_name

    def get_employee_number(self):
        return self.__employee_number

class ProductionWorker(Employee):
    def __init__(self, emp_name, emp_num, shift_num, pay_rate):
        Employee.__init__(self, emp_name, emp_num)

        self.__shift_number = shift_num
        self.__pay_rate = pay_rate

    def set_shift_number(self, shift_num):
        self.__shift_number = shift_num

    def set_pay_rate(self, pay_rate):
        self.__pay_rate = pay_rate

    def get_shift_number(self):
        if self.__shift_number == 1:
            return "Day"
        if self.__shift_number == 2:
            return "Night"

    def get_pay_rate(self):
        return self.__pay_rate