import React from 'react'
import SellerMenus from './SellerMenus'

const SellerOrders = () => {
  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <SellerMenus />
        </div>
        <div className="col-md-9">
          <h1>Orders</h1>
        </div>
      </div>
    </div>
  )
}

export default SellerOrders
