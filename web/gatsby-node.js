const path = require("path");

const onCreateWebpackConfig = ({ actions }) => {
  actions.setWebpackConfig({
    resolve: {
      alias: {
        "@/components": path.resolve(__dirname, "src/components"),
        "@/utils": path.resolve(__dirname, "src/utils"),
      },
    },
  })
}

module.exports = {
  onCreateWebpackConfig
}
