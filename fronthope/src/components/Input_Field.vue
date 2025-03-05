<script>
export default {
  name: "Input_Field",
  props: {
    label: {
      type: String,
      required: true,
    },
    id: {
      type: String,
      required: true,
    },
    type: {
      type: String,
      default: "text",
    },
    placeholder: {
      type: String,
      default: "Enter your value...",
    },
    modelValue: {
      type: String,
      default: '',
    },
  },
  methods: {
    updateValue(event) {
      this.$emit('update:modelValue', event.target.value);
    },
  },
};
</script>

<template>
  <div class="input-container">
    <label :for="id">{{ label }}</label>
    <input
        :type="type"
        :id="id"
        :placeholder="placeholder"
        :value="modelValue"
        @input="updateValue"
        required
        class="input-field"
    />
  </div>
</template>

<style scoped>
.input-container {
  display: flex;
  flex-direction: column;
}

label {
  font-family: 'Roboto', sans-serif;
  font-size: 14px;
  letter-spacing: 1px;
  text-align: left;
}

.input-field {
  width: 300px;
  font-family: 'Roboto', sans-serif;
  font-weight: normal;
  font-size: 12px;
  letter-spacing: 1px;
  font-style: italic;
  background-color: whitesmoke;
  padding: 5px;
  border-left: 2px solid black;
  border-bottom: 2px solid black;
  border-right: 1px solid black;
  border-top: 1px solid black;
  cursor: pointer;
}
</style>


<style scoped>
.input-container {
  display: flex;
  flex-direction: column;
}

label {
  font-family: 'Roboto', sans-serif;
  font-size: 14px;
  letter-spacing: 1px;
  text-align: left;
}

.input-field {
  width: 300px;
  font-family: 'Roboto', sans-serif;
  font-weight: normal;
  font-size: 12px;
  letter-spacing: 1px;
  font-style: italic;
  background-color: whitesmoke;
  padding: 5px;
  border-left: 2px solid black;
  border-bottom: 2px solid black;
  border-right: 1px solid black;
  border-top: 1px solid black;
  cursor: pointer;
}
</style>
