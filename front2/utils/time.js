export default {
  utcToDate(utc) {
    return new Date(Date.parse(utc))
  },
  dateToUtc(date) {
    return date.toJSON()
  },
  dateToDateStringWithoutYear(date) {
    return (date.getMonth() + 1).toString().padStart(2, '0') + '-' +
      date.getDate().toString().padStart(2, '0')
  },
  dateToDateString(date) {
    return date.getFullYear().toString().padStart(4, '0') + '-' +
      this.dateToDateStringWithoutYear(date)
  },
  dateToTimeString(date) {
    return date.getHours().toString().padStart(2, '0') + ':' +
      date.getMinutes().toString().padStart(2, '0')
  },
  dateToBriefTimeString(date) {
    return (date.getMonth() + 1) + '-' + date.getDate()
  },
  dateToFullString(date) {
    return this.dateToDateString(date) + ' ' + this.dateToTimeString(date)
  },
  StringToDate(dateString, timeString) {
    let offset = new Date().getTimezoneOffset()
    let sig = ''
    if (offset <= 0) {
      offset = -offset
      sig = '+'
    } else {
      sig = '-'
    }
    let hour = parseInt(offset / 60)
    let minute = offset - hour * 60
    let timeZone = sig.toString() + hour.toString().padStart(2, '0') + ':' + minute.toString().padStart(2, '0')
    return Date.parse(dateString + 'T' + timeString + timeZone)
  },
  subDay(date, day) {
    let time = date.getTime()
    return new Date(time - day * 86400000)
  }
}