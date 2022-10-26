import { Response, Request } from "express";

const {name, version, description } = require('../../../package.json');

export const ping = (req: Request, res: Response): void => {
  res.json({
    name,
    description,
    version,
    uptime: process.uptime()
  })
}