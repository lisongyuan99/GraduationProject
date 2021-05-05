module.exports = {
  publicPath: '/project/admin/',
  devServer: {
    proxy: {
      '/api/project': {
        target: 'http://localhost:50002/api/project', //对应自己的接口
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api/project': '/'
        }
      }
    }
  }
}