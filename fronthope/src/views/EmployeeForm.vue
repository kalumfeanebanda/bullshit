<script>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

export default {
  name: "EmployeeForm",
  setup() {
    const route = useRoute();
    const router = useRouter();

    const employee = ref({
      firstName: "",
      lastName: "",
      email: "",
    });

    const isEditing = ref(false);

    const saveEmployee = () => {
      if (isEditing.value) {
        axios.put(`http://localhost:8080/employees/${route.params.id}`, employee.value)
            .then(() => router.push("/EmployeeList")) // Redirect to employee list
            .catch(error => console.error("Error updating employee:", error));
      } else {
        axios.post("http://localhost:8080/employees", employee.value)
            .then(() => router.push("/EmployeeList")) // Redirect to employee list
            .catch(error => console.error("Error adding employee:", error));
      }
    };

    const fetchEmployee = () => {
      if (route.params.id) {
        isEditing.value = true;
        axios.get(`http://localhost:8080/employees/${route.params.id}`)
            .then(response => {
              employee.value = response.data;
            })
            .catch(error => console.error("Error fetching employee:", error));
      }
    };

    // Fetch employee data when the component is mounted
    onMounted(fetchEmployee);

    return {
      employee,
      isEditing,
      saveEmployee
    };
  }
};
</script>

<template>
  <div class="container">
    <h2 class="mt-4">{{ isEditing ? "Update Staff" : "Add Staff" }}</h2>
    <form @submit.prevent="saveEmployee">
      <!-- First Name -->
      <div class="form-group">
        <label>First Name:</label>
        <input type="text" v-model="employee.firstName" placeholder="Enter first name" class="form-control" required>
      </div>

      <!-- Last Name -->
      <div class="form-group">
        <label>Last Name:</label>
        <input type="text" v-model="employee.lastName" placeholder="Enter last name" class="form-control" required>
      </div>

      <!-- Email -->
      <div class="form-group">
        <label>Email:</label>
        <input type="email" v-model="employee.email" placeholder="Enter email" class="form-control" required>
      </div>

      <!-- Submit Button -->
      <button type="submit" class="btn btn-primary">
        {{ isEditing ? "Update Staff" : "Add Staff" }}
      </button>
    </form>
    <hr>

    <router-link to="/employee-list" class="btn btn-success mb-3">Add Staff</router-link>

  </div>
</template>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 15px;
}

.btn {
  margin-top: 10px;
}
</style>
