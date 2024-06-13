const user = {
  name: 'John Doe',
  email: 'johndoe@example.com',
  age: 30,

  changeName(newName) {
    this.name = newName;
  },

  updateEmail(newEmail) {
    this.email = newEmail;
  },

  calculateBirthYear() {
    const currentYear = new Date().getFullYear();
    return currentYear - this.age;
  }
};

// Example usage:

console.log(user.name); // Output: John Doe
user.changeName('Jane Doe');
console.log(user.name); // Output: Jane Doe

console.log(user.email); // Output: johndoe@example.com
user.updateEmail('janedoe@example.com');
console.log(user.email); // Output: janedoe@example.com

console.log(user.calculateBirthYear()); // Output: 1992 (assuming current year is 2022)