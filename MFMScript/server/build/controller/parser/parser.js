"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.parse = void 0;
const fs = require('fs');
const parse = (req, res) => {
    fs.readFile('./public/index.html', function (err, html) {
        if (err) {
            throw err;
        }
        res.write(html);
        res.end();
    });
};
exports.parse = parse;
