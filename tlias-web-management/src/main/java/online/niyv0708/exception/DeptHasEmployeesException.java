package online.niyv0708.exception;

/**
 * 部门下存在员工时抛出的异常
 */
public class DeptHasEmployeesException extends RuntimeException {
    public DeptHasEmployeesException() {

        super();
    }

    public DeptHasEmployeesException(String message) {
        super(message);
    }
}