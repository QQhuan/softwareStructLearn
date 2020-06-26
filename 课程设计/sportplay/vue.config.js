module.exports = {
    devServer: {
        host: 'localhost',
        port: '8080', // 端口号
        https: false, // https: {type:Bollean}
        proxy: {
            '/api': {
                target: 'http://localhost:9000', // 源地址
                changeOrigin: true, // 改变源
                ws: true,
                pathRewrite: {
                    '^/api': '' // 路径重写
                }
            }
        }
    }
}
  
  