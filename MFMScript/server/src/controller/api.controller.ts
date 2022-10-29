import * as health from './health/ping'
import * as parser from './parser/parser'

export default {
    ...health,
    ...parser
}