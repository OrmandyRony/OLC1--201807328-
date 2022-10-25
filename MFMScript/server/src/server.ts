import dotenv from 'dotenv';
import { application } from 'express';
import { PORT } from './utils/enviroments';
import appServer from './app';

dotenv.config();

appServer().then((app: typeof application) => {
  app.listen(PORT, () => {
    console.log(`Server Ready en PORT ${PORT} ${process.env.NODE_ENV}`)
    //console.log(process.env);
  })
})
.catch((err: Partial<Error> & unknown) => console.log(err))