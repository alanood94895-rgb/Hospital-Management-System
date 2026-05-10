package Services;

public class DepartmentService {

    private List<Department> departments =
            new ArrayList<>();

    // Add Department
    public void addDepartment(Department department) {
        departments.add(department);
    }
    // Remove Department
    public void removeDepartment(String departmentId) {

        departments.removeIf(
                department ->
                        department.getDepartmentId()
                                .equals(departmentId)
        );
    }

}
