package com.gfd.player.mvp.presenter

import com.gfd.player.entity.VideoItemData
import com.gfd.player.mvp.contract.PlayContract
import com.gfd.player.service.PlayService
import javax.inject.Inject

/**
 * @Author : 郭富东
 * @Date ：2018/8/6 - 14:39
 * @Email：878749089@qq.com
 * @description：
 */
class PlayPresenter @Inject constructor() : PlayContract.Presenter, PlayService.GetVideoUrlCallBack {

    @Inject
    lateinit var mView: PlayContract.View

    @Inject
    lateinit var mPlayService: PlayService

    override fun getVideoUrl(url: String) {
        mView.showLoading()
        mPlayService.getVideoUrl(url, this)
    }

    override fun getWebVideoUrl(url: String) {
        mView.showLoading()
        mPlayService.getWebVideoUrl(url, this)
    }

    override fun videoUrl(url: String, plotText: String) {
        mView.showVideoPlot(plotText)
        mView.playVideo(url)
        mView.showContent()
    }

    override fun videoWebData(data: List<VideoItemData>, plotText: String) {
        mView.showVideoPlot(plotText)
        mView.playWebVideo(data)
        mView.showContent()
    }


}