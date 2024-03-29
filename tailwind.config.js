/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html"
  ],
  theme: {
  extend: {
    fontFamily: {
        sans: ['Inter var', ...defaultTheme.fontFamily.sans],
    },
  },
        plugins: [],
    }
};

