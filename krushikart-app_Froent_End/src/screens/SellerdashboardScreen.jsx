import React from 'react'
import { useAuth } from '../context/auth'
import SellerMenus from './Seller/SellerMenus'

const SellerdashboardScreen = () => {
  const [auth] = useAuth()

  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <SellerMenus />
        </div>
        <div className="col-md-9">
          <div className="card w-75 p-3">
            <h3>
              {' '}
              Seller Name : {auth.user.firstName + ' ' + auth.user.lastName}
            </h3>
            <h3> Seller Email : {auth.user.email}</h3>
            <h3> Seller Contact : {auth.user.contactNumber}</h3>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SellerdashboardScreen
