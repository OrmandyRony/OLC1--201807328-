import dotenv from 'dotenv'
import { application } from 'express'
import { PORT } from './utils/environments';
import appServer from './app'

dotenv.config();

appServer()
.then((app: typeof application) => {
    app.listen(PORT, () => {
        console.log(`Server Ready on PORT ${PORT} ${process.env.NODE_ENV}`)
    })
})
.catch((err: Partial<Error> & unknown) => console.log(err))

