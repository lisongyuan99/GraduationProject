import area from './area'

export default {
  getRegion(code) {
    if (code % 10000 === 0) {
      return area.province_list[code]
    } else if (code % 100 === 0) {
      return area.province_list[parseInt(code / 10000) * 10000] + ' ' + area.city_list[code]
    } else {
      return area.province_list[parseInt(code / 10000) * 10000] + ' ' +
          area.city_list[parseInt(code / 100) * 100] + ' ' +
          area.county_list[code]
    }
  },
  split(str) {
    if(str === ''){
      return []
    } else {
      return str.split(/\|/)
    }
  },
  getTime(utc) {
    let date = new Date(Date.parse(utc))
    return date.getFullYear().toString().padStart(4, '0') + '-' + (date.getMonth() + 1).toString().padStart(2, '0') + '-' +
        date.getDate().toString().padStart(2, '0') + ' ' + date.getHours().toString().padStart(2, '0') + ':' +
        date.getMinutes().toString().padStart(2, '0')
  }
}