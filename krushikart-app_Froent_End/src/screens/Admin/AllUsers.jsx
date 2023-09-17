import React from 'react'
import AdminMenus from './AdminMenus'


const AllUsers = () => {
  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <AdminMenus />
        </div>
        <div className="col-md-9">
          <h1>All Users</h1>
        </div>
      </div>
    </div>
  )
}

export default AllUsers
