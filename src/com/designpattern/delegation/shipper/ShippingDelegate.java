package com.designpattern.delegation.shipper;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ShippingDelegate implements Shipper {
	public void deliver(PackageInfor item) {
		if (item.getWeight() > 100) {
			this.useRail().deliver(item);
		} else {
			this.useTruck().deliver(item);
		}
	}

	/**
	 * Uses TruckShipper to deliver the package
	 * 
	 * @return TruckShipper
	 */
	public Shipper useTruck() {
		return new TruckShipper();
	}

	/**
	 * Uses RailShipper to deliver the package
	 * 
	 * @return RailShipper
	 */
	public Shipper useRail() {
		return new RailShipper();
	}
}