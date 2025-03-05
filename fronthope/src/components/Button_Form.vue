
<script>
export default {
  name: "Button_Form",
  props: {
    label: {
      type: String,
      required: true,
    },
    type: {
      type: String,
      default: "button", // Default to 'button' to prevent form submission issues
    },
  },
};
</script>

<template>
  <button :type="type" class="form-btn" @click="$emit('click')">
    {{ label }}
  </button>
</template>

<style scoped>
.form-btn {
  font-family: 'Roboto', sans-serif;
  font-weight: bold;
  letter-spacing: 1px;
  text-shadow: 0 4px 4px rgba(0, 0, 0, 0.3);
  width: 300px; /* Updated width to match the input field */
  background-color: #D3C9AD;
  padding: 5px; /* Ensures consistent padding with the input field */
  border-left: 2px solid black;
  border-bottom: 2px solid black;
  border-right: 1px solid black;
  border-top: 1px solid black;
  cursor: pointer;
  font-size: 14px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3);
}
</style>
