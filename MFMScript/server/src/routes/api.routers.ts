import controller from '../controller/api.controllers';
import express from 'express';
const router = express.Router();

router.get('/ping', controller.ping);
router.post('/parse', controller.parse);

export default router;