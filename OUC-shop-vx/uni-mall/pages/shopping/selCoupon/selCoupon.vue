<template>
	<view class="container">
		<view class='not-use' @tap='noUseCoupon'>不使用优惠券</view>
		<view class="help">使用说明</view>
		<show-empty v-if="couponList.length<=0" text="暂无优惠券"></show-empty>
		<view v-else class="coupon-list">
			<block v-for="(item, index) in couponList" :key="item.id">
				<view :data-item="item" @tap='tapCoupon' class="item" :style="'background: ' + (item.enabled==1?'linear-gradient(to right,#cfa568,#e3bf79)':'linear-gradient(to right,#999,#DDDDDD)')">
					<view class="content">
						<view class="left">
							<view class="name">{{item.name}}</view>
							<view class="time">有效期至{{item.useEndDate}}</view>
						</view>
						<view class="right">
							<image v-if="item.enabled==1" class='mid-img' src='../../../static/images/coupon_ksy.png'></image>
							<image v-if="item.enabled==0" class='mid-img' src='../../../static/images/coupon_bky.png'></image>
						</view>
					</view>
					<view class="condition">
						<text class="txt">满￥{{item.minGoodsAmount}} 减￥{{item.typeMoney}}</text>
					</view>
				</view>
			</block>
		</view>
	</view>
</template>

<script>
	const util = require("@/utils/util.js");
	const api = require('@/utils/api.js');
	export default {
		data() {
			return {
				couponList: null,
				buyType: ''
			}
		},
		methods: {
			loadListData: function() {
				let that = this;
				util.request(api.GoodsCouponList, {
					type: this.buyType
				}).then(function(res) {
					if (res.errno === 0) {
						that.couponList = res.data
					}
				});
			},

			/**
			 * 点击不使用优惠券
			 * 返回上一页
			 */
			noUseCoupon: function() {
				uni.navigateBack()
			},

			tapCoupon: function(event) {
				let item = event.currentTarget.dataset.item
				if (item.enabled == 0) {
					return
				}
				uni.navigateBack()
			}
		},
		onLoad: function(options) {
			this.buyType = options.buyType
			this.loadListData()
		}
	}
</script>

<style lang="scss">
	page {
		background: #f4f4f4;
		min-height: 100%;
	}

	.container {
		background: #f4f4f4;
		min-height: 100%;
		padding-top: 30rpx;
	}

	.not-use {
		margin: 30rpx auto 30rpx;
		width: 690rpx;
		height: 88rpx;
		background-color: #e3e3e3;
		border-radius: 5rpx;
		font-size: 32rpx;
		font-weight: normal;
		font-stretch: normal;
		line-height: 0px;
		letter-spacing: 0px;
		color: #fff;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.coupon-form {
		height: 110rpx;
		width: 100%;
		background: #fff;
		padding-left: 30rpx;
		padding-right: 30rpx;
		padding-top: 20rpx;
		display: flex;
	}

	.input-box {
		flex: 1;
		height: 70rpx;
		color: #333;
		font-size: 24rpx;
		background: #fff;
		position: relative;
		border: 1px solid rgba(0, 0, 0, 0.15);
		border-radius: 4rpx;
		margin-right: 30rpx;
	}

	.input-box .coupon-sn {
		position: absolute;
		top: 10rpx;
		left: 30rpx;
		height: 50rpx;
		width: 100%;
		color: #000;
		line-height: 50rpx;
		font-size: 24rpx;
	}

	.clear-icon {
		position: absolute;
		top: 21rpx;
		right: 30rpx;
		width: 28rpx;
		height: 28rpx;
	}

	.add-btn {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 70rpx;
		border: none;
		width: 168rpx;
		background: #b4282d;
		border-radius: 0;
		line-height: 70rpx;
		color: #fff;
		font-size: 28rpx;
	}

	.add-btn.disabled {
		background: #ccc;
	}

	.help {
		height: 72rpx;
		line-height: 72rpx;
		text-align: right;
		padding-right: 30rpx;
		background: url(https://platform-wxmall.oss-cn-beijing.aliyuncs.com/upload/20180727/15032866437ca8.png) 590rpx center no-repeat;
		background-size: 28rpx;
		color: #999;
		font-size: 24rpx;
	}

	.coupon-list {
		width: 100%;
		height: auto;
		overflow: hidden;
		padding-left: 30rpx;
		padding-right: 30rpx;
	}

	.item {
		position: relative;
		height: 290rpx;
		width: 100%;
		border-radius: 8rpx;
		margin-bottom: 30rpx;
		padding-top: 52rpx;
	}

	.tag {
		height: 32rpx;
		background: #A48143;
		padding-left: 16rpx;
		padding-right: 16rpx;
		position: absolute;
		left: 20rpx;
		color: #fff;
		top: 20rpx;
		font-size: 20rpx;
		text-align: center;
		line-height: 32rpx;
	}


	.content {
		margin-top: 24rpx;
		margin-left: 40rpx;
		display: flex;
		margin-right: 40rpx;
		flex-direction: row;
		align-items: center;
	}

	.content .left {
		flex: 1;
	}

	.name {
		font-size: 44rpx;
		color: #fff;
		margin-bottom: 14rpx;
	}

	.time {
		font-size: 24rpx;
		color: rgba(255, 255, 255, 0.8);
		line-height: 30rpx;
	}

	.content .right {
		width: 162rpx;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.content .right .mid-img {
		width: 100rpx;
		height: 100rpx;
	}

	.condition {
		position: absolute;
		width: 100%;
		bottom: 0;
		left: 0;
		height: 78rpx;
		background: rgba(0, 0, 0, .08);
		padding: 24rpx 40rpx;
		display: flex;
		flex-direction: row;
	}

	.condition .txt {
		display: block;
		height: 30rpx;
		flex: 1;
		overflow: hidden;
		font-size: 24rpx;
		line-height: 30rpx;
		color: #fff;
	}


	.condition .icon {
		margin-left: 30rpx;
		width: 24rpx;
		height: 24rpx;
	}
</style>
