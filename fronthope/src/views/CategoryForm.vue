<script>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

export default {
  name: "CategoryForm",
  setup() {
    const route = useRoute();
    const router = useRouter();

    const category = ref({
      name: "",
      description: "",
      unit: "",
      calculation: "",
    });

    const isEditing = ref(false);

    const saveCategory = () => {
      if (isEditing.value) {
        axios.put(`http://localhost:8080/category/${route.params.id}`, category.value)
            .then(() => router.push("/listCategory")) // Redirect to category list
            .catch(error => console.error("Error updating category:", error));
      } else {
        axios.post("http://localhost:8080/category", category.value)
            .then(() => router.push("/listCategory")) // Redirect to category list
            .catch(error => console.error("Error adding category:", error));
      }
    };

    const fetchCategory = () => {
      if (route.params.id) {
        isEditing.value = true;
        axios.get(`http://localhost:8080/category/${route.params.id}`)
            .then(response => {
              category.value = response.data;
            })
            .catch(error => console.error("Error fetching category:", error));
      }
    };

    // Fetch category data when the component is mounted
    onMounted(fetchCategory);

    return {
      category,
      isEditing,
      saveCategory
    };
  }
};
</script>


<template>
  <div class="container">
    <h2 class="mt-4">{{ isEditing ? "Update Category" : "Add Category" }}</h2>
    <form @submit.prevent="saveCategory">
      <!-- First Name -->
      <div class="form-group">
        <label>Name:</label>
        <input type="text" v-model="category.name" placeholder="Category Name" class="form-control"
               required>
      </div>
      <!-- Last Name -->
      <div class="form-group">
        <label>Description:</label>
        <input type="text" v-model="category.description" placeholder="Category description" class="form-control"
               required>
      </div>
      <!-- Email -->
      <div class="form-group">
        <label>Unit:</label>
        <input type="text" v-model="category.unit" placeholder="Category Unit" class="form-control" required>
      </div>

      <div class="form-group">
        <label>Calculation:</label>
        <input type="text" v-model="category.calculation" placeholder="Category Calculation" class="form-control"
               required>
      </div>


      <!-- Submit Button -->
      <button type="submit" class="btn btn-primary">
        {{ isEditing ? "Update Category" : "Add Category" }}
      </button>
    </form>
    <hr>
    <!-- Back to Employee List -->
    <router-link to="/listCategory" class="btn btn-secondary">Back to Category List</router-link>
  </div>

</template>

<style scoped>

</style>