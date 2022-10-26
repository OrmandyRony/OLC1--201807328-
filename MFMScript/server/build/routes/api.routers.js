"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const api_controllers_1 = __importDefault(require("../controller/api.controllers"));
const express_1 = __importDefault(require("express"));
const router = express_1.default.Router();
router.get('/ping', api_controllers_1.default.ping);
router.get('/index', api_controllers_1.default.parse);
exports.default = router;
