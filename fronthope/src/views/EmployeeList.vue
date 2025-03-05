<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import { Modal } from "bootstrap";

export default {
  name: "EmployeeList",
  setup() {
    const employees = ref([]);
    const successMessage = ref("");
    const selectedEmployee = ref({});
    const deleteModalInstance = ref(null);

    // Fetch employees from API
    const fetchEmployees = () => {
      axios.get("http://localhost:8080/employees")
          .then(response => {
            employees.value = response.data;
          })
          .catch(error => console.error("Error fetching employees:", error));
    };

    // Show delete modal
    const showDeleteModal = (employee) => {
      selectedEmployee.value = employee;
      if (deleteModalInstance.value) {
        deleteModalInstance.value.show();
      }
    };

    // Delete employee
    const deleteEmployee = () => {
      axios.delete(`http://localhost:8080/employees/${selectedEmployee.value.id}`)
          .then(() => {
            successMessage.value = "Employee deleted successfully!";
            fetchEmployees(); // Refresh list
            deleteModalInstance.value.hide();
          })
          .catch(error => console.error("Error deleting employee:", error));
    };

    // Initialize Bootstrap modal on mount
    onMounted(() => {
      fetchEmployees();
      deleteModalInstance.value = new Modal(document.getElementById("deleteModal"));
    });

    return {
      employees,
      successMessage,
      selectedEmployee,
      showDeleteModal,
      deleteEmployee,
    };
  }
};
</script>

<template>
  <div class="container">
    <h2>Staff List</h2>

    <!-- Add Employee Button -->
    <router-link to="/add-employee" class="btn btn-success mb-3">Add Staff</router-link>

    <!-- Success Alert -->
    <div v-if="successMessage" class="alert alert-success alert-dismissible fade show">
      {{ successMessage }}
      <button type="button" class="btn-close" @click="successMessage = ''"></button>
    </div>

    <table class="table">
      <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>

      </tr>
      </thead>
      <tbody>
      <tr v-for="employee in employees" :key="employee.id">
        <td>{{ employee.firstName }}</td>
        <td>{{ employee.lastName }}</td>
        <td>{{ employee.email }}</td>
        <td>
          <router-link :to="`/edit-employee/${employee.id}`" class="btn btn-warning">Edit</router-link>
          <button type="button" class="btn btn-danger" @click="showDeleteModal(employee)">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>

    <!-- Delete Confirmation Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Confirm Delete</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
          <div class="modal-body">
            <p>Are you sure you want to delete <strong>{{ selectedEmployee.firstName }} {{ selectedEmployee.lastName }}</strong>?</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" @click="deleteEmployee">Yes, Delete</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: auto;
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.btn {
  margin-right: 5px;
}
</style>
