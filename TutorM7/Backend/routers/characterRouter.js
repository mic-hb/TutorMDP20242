const express = require("express");
const router = express.Router();
const upload = require("../middlewares/uploadMiddleware");
const {
  getAllHeroes,
  getHeroByName,
  deleteHero,
  getDeletedHeroes,
  createHero,
  updateHero,
} = require("../controllers/charactersController");

router.get("/", getAllHeroes);
router.get("/name/:name", getHeroByName);
router.get("/deleted", getDeletedHeroes);
router.delete("/:id", deleteHero);
router.post("/add", createHero);
router.put("/update/:id", updateHero);

module.exports = router;
