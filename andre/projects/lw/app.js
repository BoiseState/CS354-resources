const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const logger = require('morgan');

const indexRouter = require('./routes/index');
const exampleRouter = require('./routes/example');

const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/example', exampleRouter);

module.exports = app;


/**
 *
 * Error Handlers
 *
 */
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    err.message = err.message || 'Internal Server Error';
    log.error(err.status + ' - ' + err.message + ': Error in request of ' + req.originalUrl + ' from ' + req.ip);
    log.error(err.message);
    log.error(err.stack);
    res.send(err.status + ': ' + err.message);
});


app.use(function(req, res, next) {
    let err = new Error('Not Found');
    err.status = 404;
    next(err);
  });
