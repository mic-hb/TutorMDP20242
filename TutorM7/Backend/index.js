const express = require("express");
const cors = require("cors");
const app = express();
const path = require('path');
const port = 3000;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use("/uploads", express.static(path.join(__dirname, "uploads")));

const characterRouter = require("./routers/characterRouter");
app.use("/api/heroes", characterRouter);

app.get("/", (req, res) => {
  res.send("Server is running");
});

app.listen(port, () => {
  console.log(`Server is running at port ${port}`);
});
