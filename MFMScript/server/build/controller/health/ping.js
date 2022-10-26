"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ping = void 0;
const { name, version, description } = require('../../../package.json');
const ping = (req, res) => {
    res.json({
        name,
        description,
        version,
        uptime: process.uptime()
    });
};
exports.ping = ping;
