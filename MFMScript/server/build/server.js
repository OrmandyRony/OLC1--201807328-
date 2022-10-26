"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const dotenv_1 = __importDefault(require("dotenv"));
const enviroments_1 = require("./utils/enviroments");
const app_1 = __importDefault(require("./app"));
dotenv_1.default.config();
(0, app_1.default)().then((app) => {
    app.listen(enviroments_1.PORT, () => {
        console.log(`Server Ready en PORT ${enviroments_1.PORT} ${process.env.NODE_ENV}`);
        //console.log(process.env);
    });
})
    .catch((err) => console.log(err));
