/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const map = {
        '(': ')',
        '[': ']',
        '{': '}'
    }
    const left = ['(', '[', '{']
    let isValid = true
    let record = []
    for (let i in s) {
        const entry = s[i]
        if (left.indexOf(entry) > -1) {
            record.push(entry)
        } else {
            const latest = record.pop()
            if (map[latest] !== entry) {
                return false
            }
        }
    }
    return isValid && record.length === 0
};