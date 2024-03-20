const express = require('express');
const router = express.Router();

/* GET an example resource. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');

  //this is where you would hook into a database or something!
});

module.exports = router;
