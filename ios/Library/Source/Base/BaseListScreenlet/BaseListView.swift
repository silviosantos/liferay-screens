/**
* Copyright (c) 2000-present Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
import UIKit


public class BaseListView: BaseScreenletView {

	public var rowCount:Int = 0

	public var rows:[AnyObject?] {
		set {
			let oldRows = _rows
			_rows = newValue
			onChangedRows(oldRows)
		}
		get {
			return _rows
		}
	}

	internal var onSelectedRowClosure: (AnyObject -> Void)?
	internal var fetchPageForRow: (Int -> Void)?

	private var _rows:[AnyObject?] = []

	internal func onChangedRows(oldRows:[AnyObject?]) {
	}

}
