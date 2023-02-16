var path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
module.exports = {
    entry: './src/lib/index.js',
    output: {
        path: path.join(__dirname, './dist'),
        filename: 'webpackLearn.js'
    },
    module: {
        rules: [{
                test: /\.vue$/,
                loader: 'vue-loader',
            },
            { // 添加这个json，解决如上的报错问题
                test: /\.scss$/,
                use: ['style-loader', 'css-loader', 'sass-loader']
            },


        ]
    },
    plugins: [
        new VueLoaderPlugin()

    ]
}